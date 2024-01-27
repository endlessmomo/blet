package yuki.blet.adaptor.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yuki.blet.domain.member.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
