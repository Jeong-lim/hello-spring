package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); // ctrl + p 하면 생성자를 뭘 넣어줘야하는지 뜬다.
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); // 구현체
    }
}

