package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     *  회원가입
     */

    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
        Optional<Member> result = memberRepository.findByName(member.getName()); // optional 반환
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        // ctrl + alt + v
        memberRepository.save(member);
        return member.getId();
    }
}
