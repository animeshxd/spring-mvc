package com.example.todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/todo")
public class Todo {
	
	List<String> list= new ArrayList<String>();
	
	@GetMapping("/")
	public ModelAndView index() {
		var modelAndView = new ModelAndView("todo/index.jsp");
		modelAndView.addObject("data", list);
		return modelAndView;
	}
	
	@PostMapping("/")
	public void add(@RequestParam("data") String data, HttpServletResponse resp) throws IOException {
		list.add(data);
		resp.sendRedirect("");
		// for fixing : firefox asking to resend data on refresh
	}
	
	@DeleteMapping("/clear")
	@ResponseBody
	public String clear() {
		list.clear();
		return "deleted";
	}
	
	
	
	
}
