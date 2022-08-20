package com.example.blog;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.database.Manager;
import com.example.models.Blog;

@Controller
@RequestMapping("/blog")
public class App {
	private Manager<Blog> blogs;

	@Autowired
	public void setBlogs(Manager<Blog> blogs) {
		this.blogs = blogs;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("blogs", blogs.list());
		return "blog/index.jsp";
	}
	
	
	@GetMapping("/create")
	public String create(Model model) {
		var id = UUID.randomUUID().toString();
		model.addAttribute("id", id);
		var blog = blogs.read(id);
		if (blog != null)
			model.addAttribute("blog", blog);
		return "blog/create.jsp";
	}
	
	@PostMapping("/create")
	public String addblog(
			@ModelAttribute("blog") Blog blog,
			Model model
			) throws Exception {
		blogs.create(blog);
		model.addAttribute("success", true);
		return "blog/post.jsp";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") String id, Model model) throws Exception {
		var blog = blogs.delete(id);
		if (blog == 0) {
			model.addAttribute("success", false);
		}else {
			model.addAttribute("success", true);
		}
		model.addAttribute("blogs", blogs.list());
		return "blog/index.jsp";
	}
	
	@GetMapping("/post")
	public String viewpost(@RequestParam("id") String id, Model model) {
		var blog = blogs.read(id);
		if (blog == null) {
			return "blog/index.jsp";
		}
		model.addAttribute("blog", blog);
		return "blog/post.jsp";
	}


	@GetMapping("/edit")
	public String editPost(@RequestParam("id") String id, Model model){
		var blog = blogs.read(id);
		model.addAttribute("id", id);
		if (blog == null){
			return "blog/create.jsp";
		}
		model.addAttribute("blog", blog);
		return "blog/create.jsp";

	}
	
}

