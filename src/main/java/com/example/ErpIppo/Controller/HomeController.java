package com.example.ErpIppo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class HomeController {
    @GetMapping("")
    public String GetViewHome()
    {
        return "home";
    }
}
