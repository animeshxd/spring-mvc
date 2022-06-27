package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
