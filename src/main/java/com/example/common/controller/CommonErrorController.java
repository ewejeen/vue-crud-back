package com.example.common.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author yoojinkim
 */
@Controller
public class CommonErrorController implements ErrorController {
    @GetMapping("/error")
    public String redirectRoot(){
        return "index.html";
    }
    public String getErrorPath(){
        return "/error";
    }
}
