package com.virinchi.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {

    @GetMapping("/mail")
    public String mail(HttpSession session) {
        if(session.getAttribute("activeUser") != null) {
            return "mail";

        }
        else
        {
            return "frontPage";
        }


    }



}
