package com.example;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class App {

    @RequestMapping("/hello")
    public void add(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        System.out.println("got response");
        resp.getWriter().println("hello World");
    }

    @RequestMapping("/home")
    public String index(Model model){
    	model.addAttribute("data", "this data is from A.index() ");
        return "index";
    }
    
    @RequestMapping("/page")
    public ModelAndView page() {
    	ModelAndView modelAndView = new ModelAndView("page");
    	modelAndView.addObject("data", "This is from App.page()");
    	return modelAndView;
    }
    
    @RequestMapping("/more")
    public ModelAndView more() {
    	var modelAndView = new ModelAndView("more");
    	
    	modelAndView.addObject("string", "Hello String");
    	
    	modelAndView.addObject("_int", 1234);
    	
    	var list = List.of("A", "B", "C", "D");
    	modelAndView.addObject("list", list);
    	
    	
    	var datetime = LocalDateTime.now();
    	modelAndView.addObject("datetime", datetime);	
    	
    	
    	return modelAndView;
    }
}
