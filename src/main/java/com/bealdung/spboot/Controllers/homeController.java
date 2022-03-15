package com.bealdung.spboot.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    @Value("${spring.application.name}")
    private  String name;
    @GetMapping("/home")
    public String goToHome(Model model)
    {
    model.addAttribute("name",name);
        return "home";
    }
}
