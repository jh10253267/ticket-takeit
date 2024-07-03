package com.tickettakeit.domain.member.controller;

import com.tickettakeit.domain.member.dto.Member;
import com.tickettakeit.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping(path = "/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/loginform")
    public String loginform() {
        return "loginform";
    }

    @RequestMapping("/loginerror")
    public String loginerror(@RequestParam("login_error") String loginError) {
        return "loginerror";
    }

    @GetMapping("/joinform")
    public String joinform() {
        return "joinform";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute Member member) {
        System.out.println(member);
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberService.addMember(member, false);
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/memberinfo")
    public String memberInfo(Principal principal, ModelMap modelMap) {
        String loginId = principal.getName();
        Member member = memberService.getMemberByEmail(loginId);
        modelMap.addAttribute("member", member);

        return "memberinfo";
    }
    @GetMapping("/test")
    public String test(Principal principal) {
        return "test";
    }
}
