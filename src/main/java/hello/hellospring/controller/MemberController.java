package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
}

//    @Autowired // 생성자에 Autowired라고 되어있으면 Spring에 있는 memberService를 가져다가 연결을 해준다.
//    public MemberController(MemberService memberService) { // 빨간줄이 띄워지는건 intellj의 IDEA가 해주는 것
//        this.memberService = memberService;
//    } // constructor 단축키 Alt + insert
//}

// Controller와 Service를 연결시켜줄 때 Autowired를 생성자에 쓰면 MemberController가
// 생성이 될 때 Spring 빈에 등록되어있는 MemberService객체를 가져다가 넣어준다.
// 밖에서 스프링이 넣어주는 것이다.
