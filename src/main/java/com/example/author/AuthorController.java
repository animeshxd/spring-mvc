package com.example.author;

// import static com.example.x.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.database.Manager;
import com.example.models.Author;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {
	
	Manager<Author> authors;

	@Autowired
	public void setManager(Manager<Author> authors) {
		this.authors = authors;
	}

	@RequestMapping("/")
	public String index(){
		return "redirect:../blog/";
	}
	
	@GetMapping("/register")
	public String register() {	


		return "author/register.jsp";
	}
	
	@PostMapping("/register")

	public String register(@ModelAttribute("author") @Valid  Author author, 
							BindingResult result, Model model){

		// print(author.email, author.name, author.password, author.username);
		if(result.hasErrors()) {
            return "author/register.jsp";
        }

		if(authors.read(author.username) != null){
			model.addAttribute("error", "username already exists"); 
			return "author/register.jsp";
		}
		authors.create(author);
		return "author/login.jsp";
	}

	@GetMapping("/login")
	public String login(){
		return "author/login.jsp";
	}

	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						Model model
					   )	
	{
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		var author = authors.read(username);
		if(author == null){
			model.addAttribute("error", "username does not exists"); 
			return "author/login.jsp";
		}		
		if (!author.password.equals(password)){
			model.addAttribute("error", "password mismatch"); 
			return "author/login.jsp";
		}		
		return "redirect:../blog/";
	}

	@GetMapping("/update")
	public String update() {

		return "author/";
	}
	
}
