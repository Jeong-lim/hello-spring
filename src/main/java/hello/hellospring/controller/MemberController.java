package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // 생성자에 Autowired라고 되어있으면 Spring에 있는 memberService를 가져다가 연결을 해준다.
    public MemberController(MemberService memberService) { // 빨간줄이 띄워지는건 intellj의 IDEA가 해주는 것
        this.memberService = memberService;
    } // constructor 단축키 Alt + insert
}
