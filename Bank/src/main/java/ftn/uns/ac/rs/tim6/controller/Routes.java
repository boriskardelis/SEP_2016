package ftn.uns.ac.rs.tim6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public  class Routes {

    @RequestMapping({
        "/about",
        "/home",
        "/tracks/{id:\\w+}",
        "/payment",

        
       
    })
    public String index() {
        return "forward:/index.html";
    }
}