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
	public void addblog(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			HttpServletResponse resp
			) throws Exception {
		
		var id = UUID.randomUUID();
		var blogpost = new Blog(id.toString(), title, content);
		blogs.put(id.toString(), blogpost);
		resp.sendRedirect("../blog/");
	}
	
	@GetMapping("/delete")
	public void delete(@RequestParam("id") String id, HttpServletResponse resp) throws Exception {
		blogs.remove(id);
		resp.sendRedirect("../blog/");
	}
	
}
