package com.example.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView add(@RequestParam("data") String data) {
		var modelAndView = new ModelAndView("todo/index.jsp");
		list.add(data);
		modelAndView.addObject("data", list);
		return modelAndView;
	}
	
	
}
