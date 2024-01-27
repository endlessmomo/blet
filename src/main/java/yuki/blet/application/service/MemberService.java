package yuki.blet.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yuki.blet.application.port.in.MemberJoinCommand;
import yuki.blet.application.port.in.MemberUseCase;
import yuki.blet.application.port.out.MemberOutPort;
import yuki.blet.domain.member.Member;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

  private final MemberOutPort memberOutPort;

  @Transactional
  @Override
  public void join(MemberJoinCommand memberJoinCommand) {
    Member member = memberJoinCommand.toMemberEntity();
    memberOutPort.save(member);
  }
}
