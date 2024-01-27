package yuki.blet.adaptor.out.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yuki.blet.application.port.out.MemberOutPort;
import yuki.blet.domain.member.Member;

@Service
@RequiredArgsConstructor
public class MemberPersistenceAdaptor implements MemberOutPort {
  private final MemberRepository memberRepository;

  @Override
  public void save(Member member) {
    memberRepository.save(member);
  }
}
