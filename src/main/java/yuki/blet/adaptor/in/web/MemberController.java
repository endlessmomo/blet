package yuki.blet.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuki.blet.application.port.in.MemberJoinCommand;
import yuki.blet.application.port.in.MemberUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

  private final  MemberUseCase memberUseCase;
  @PostMapping("/public/join")
  public ResponseEntity join(@RequestBody MemberJoinCommand memberJoinCommand) {
    memberUseCase.join(memberJoinCommand);
    return ResponseEntity.status(HttpStatus.CREATED).body("성공하셨습니다.");
  }
}
