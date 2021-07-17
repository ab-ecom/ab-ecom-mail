package com.anirudhb2b.mail.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SwaggerController {
    @GetMapping
    public String redirectToSwagger() {
        return "redirect:swagger-ui.html";
    }
}
