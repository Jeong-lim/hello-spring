package hello.hellospring.repository;
// 회원 객체를 저장하는 저장소

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // null을 반환하는 방법
    Optional<Member> findByName(String name);
    List<Member> findAll();
}