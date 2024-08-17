package com.example.studyfirst.controller;

import com.example.studyfirst.domain.Member;
import com.example.studyfirst.service.MemberService;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@Controller
public class MemberController {

    

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //새로운 회원 생성후 저장
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setId(form.getId());
        member.setPassword((form.getPassword()));
        memberService.join(member);
        return "redirect:/";
    }

    //로그인할떄 아이디, 비밀번호 확인
    @PostMapping("/member/logIn")
    public String logIn(MemberForm form, HttpSession session){
        List<Member> members = memberService.findMembers();
        for(Member member : members) {
            if(member!=null && member.getId().equals(form.getId()) && member.getPassword().equals(form.getPassword())){
                session.setAttribute("loggedInMember",member);
                return "redirect:/home";
            }
        }

        return "redirect:/";
    }

    //로그인 후에 화면을 표시
    @GetMapping("/home")
    public String getHome(Model model, HttpSession session) {
        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
        if (loggedInMember != null) {
            model.addAttribute("member", loggedInMember);
            return "home";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/update")
    public String updateMember(MemberForm form, HttpSession session){
        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
        loggedInMember.setName(form.getName());
        loggedInMember.setAge(form.getAge());
        loggedInMember.setAddress(form.getAddress());
        loggedInMember.setBlType(form.getBlType());
        memberService.updateMember(loggedInMember);
        return "redirect:/home";
    }

}
