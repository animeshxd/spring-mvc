package com.example.blog;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.blog.models.Blog;

@Controller
@RequestMapping("/blog")
public class App {
	
	Map<String, Blog> blogs = new TreeMap<String, Blog>();
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("blogs", blogs);
		return "blog/index.jsp";
	}
	
	
	@GetMapping("/create")
	public String create(Model model) {
		var id = UUID.randomUUID().toString();
		model.addAttribute("id", id);
		var blog = blogs.get(id);
		if (blog != null)
			model.addAttribute("blog", blog);
		return "blog/create.jsp";
	}
	
	@PostMapping("/create")
	public String addblog(
			@RequestParam("id") String id,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			Model model
			) throws Exception {
		var blog = new Blog(id, title, content);
		blogs.put(id, blog);
		model.addAttribute("blog", blog);
		model.addAttribute("success", true);
		return "blog/post.jsp";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") String id, Model model) throws Exception {
		var blog = blogs.remove(id);
		if (blog == null) {
			model.addAttribute("success", false);
		}else {
			model.addAttribute("success", true);
		}
		model.addAttribute("blogs", blogs);
		return "blog/index.jsp";
	}
	
	@GetMapping("/post")
	public String viewpost(@RequestParam("id") String id, Model model) {
		var blog = blogs.get(id);
		if (blog == null) {
			return "blog/index.jsp";
		}
		model.addAttribute("blog", blog);
		return "blog/post.jsp";
	}


	@GetMapping("/edit")
	public String editPost(@RequestParam("id") String id, Model model){
		var blog = blogs.get(id);
		model.addAttribute("id", id);
		if (blog == null){
			return "blog/create.jsp";
		}
		model.addAttribute("blog", blog);
		return "blog/create.jsp";

	}
	
}

