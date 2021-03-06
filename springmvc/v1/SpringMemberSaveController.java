package com.hello.jspmvc.servlet.web.springmvc.v1;

import com.hello.jspmvc.servlet.member.Member;
import com.hello.jspmvc.servlet.member.MemberRepository;
import com.hello.jspmvc.servlet.web.frontcontroller.ModelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class SpringMemberSaveController {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(Map<String, String> paramMap){
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }
}
