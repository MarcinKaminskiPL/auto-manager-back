package net.mkaminski.autoManagerBackend.thymeleafController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping
    public String get(){
        return "index";
    }
}
