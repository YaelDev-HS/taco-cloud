package com.taco.cloud.taco_cloud;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

}

