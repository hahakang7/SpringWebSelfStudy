package com.example.studyfirst.controller;

import com.example.studyfirst.domain.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "logIn";
    }

    @GetMapping("/modify")
    public String getModify(Model model, HttpSession session) {
        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
        if (loggedInMember != null) {
            model.addAttribute("member", loggedInMember);
            return "modify";
        } else {
            return "redirect:/home";
        }
    }

    @GetMapping("/signIn")
    public String signIn(){
        return "signIn";
    }
}
