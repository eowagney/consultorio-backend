package com.consultorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularController {

    @GetMapping({
        "/", 
        "/{path:[^\\.]*}", 
        "/{path:^(?!api$).*$}/**/{subPath:[^\\.]*}"
    })
    public String redirect() {
        return "forward:/index.html";
    }
}
