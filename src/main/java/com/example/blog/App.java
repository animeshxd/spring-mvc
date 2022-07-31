package com.example.blog;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.blog.models.Blog;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/blog")
public class App {
	
	Map<String, Blog> blogs = new ConcurrentHashMap<String, Blog>();
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("blogs", blogs);
		return "blog/index.jsp";
	}
	
	
	@GetMapping("/create")
	public String create() {
		return "blog/create.jsp";
	}
	
	@PostMapping("/create")
	public String addblog(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			Model model
			) throws Exception {
		
		var id = UUID.randomUUID();
		var blogpost = new Blog(id.toString(), title, content);
		blogs.put(id.toString(), blogpost);
		model.addAttribute("blog", blogpost);
		model.addAttribute("success", true);
		return "blog/post.jsp";
	}
	
	@GetMapping("/delete")
	public void delete(@RequestParam("id") String id, HttpServletResponse resp) throws Exception {
		blogs.remove(id);
		resp.sendRedirect("./");
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
	
}
