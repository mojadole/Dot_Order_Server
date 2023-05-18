package com.dotorder.DotOrder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sample {
    @RequestMapping("/web")
    public String greeting(){
        return "web";
    }
}
