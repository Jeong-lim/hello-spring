package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


// Controller를 통해서 외부 요청을 받고 Service에서 비즈니스 로직을 만들고 Repository에서 데이터를 저장을 하는것이 정형화된 패턴이다.
@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static final Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 문제가 있어서 쓰면안되고 예제니까 씀
    private static long sequence = 0L;
    // sequence는 0, 1, 2 같은 키값을 생성을 해주는 역할

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 시퀀스 값을 올려주고 store에다 넣기 전에 멤버의 id값 세팅
        store.put(member.getId(), member); // store에 저장 -> 그럼 맵에 저장됨
        return member;

    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // 원래는 그냥 스토어에서 꺼내면 됌
        // 하지만 null이 반환될 가능성이 있다.
        // 때문에 null을 감싸서 반환하면 클라이언트에서 뭘 할 수가 있다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    public void clearStore() {
        store.clear(); // 싹 비움
    }
}
