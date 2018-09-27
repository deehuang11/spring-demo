package com.example.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class IndexController {

    @RequestMapping("/index")
    public String forward(Model model) {
        model.addAttribute("name", "Stefanie");
        model.addAttribute("pw", "dee78");
        return "fragments/index";
    }
}
