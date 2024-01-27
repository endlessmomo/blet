package yuki.blet.application.port.out;

import org.springframework.stereotype.Service;
import yuki.blet.domain.member.Member;

public interface MemberOutPort {
  void save(Member member);
}
