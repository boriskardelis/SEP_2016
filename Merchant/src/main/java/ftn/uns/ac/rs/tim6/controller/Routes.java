package ftn.uns.ac.rs.tim6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public  class Routes {

    @RequestMapping({
        "/about",
        "/paymentSuccessful",
        "/buy",
        "/home",
        "/tracks/{id:\\w+}",
        "/buy/firstStep",
        "/buy/secondStep",
        "/buy/thirdStep",
        "/buy/fourthStep",
        "/buy/fifthStep",
        
       
    })
    public String index() {
        return "forward:/index.html";
    }
}
