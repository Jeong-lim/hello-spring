package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    // Spring 컨테이너에 있는 MemberRepository를 넣어준다. MemoryMemberRepository를 Service에 주입을 시켜준다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } // 내가 직접 new에서 생성하는게 아니라 외부에서 넣어주도록 설계

    /**
     *  회원가입
     */

    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); // 뽑아내는 단축키 ctrl + alt + m
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // null이 있으면 optional로 감싸서 관련 메서드들을 쓰는것이 바람직하다
                .ifPresent(m -> { // 만약 값이 있으면
                    throw new IllegalStateException("이미 존재하는 회원입니다."); // result가 null이 아니라 값이 있으면
        }); // ctrl + alt + v optional 관련 단축키
    }

    // 회원가입을 중복으로 했을 때 기능을 하는지

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
