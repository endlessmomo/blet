package yuki.blet.application.port.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yuki.blet.domain.member.Address;
import yuki.blet.domain.member.Birth;
import yuki.blet.domain.member.Member;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinCommand {

  private String name;
  private String email;
  private String password;
  private String phoneNumber;
  private String zipcode;
  private String city;
  private String district;
  private String detail;

  @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate birth;

  public Member toMemberEntity() {
    return Member.builder()
        .name(this.name)
        .email(this.email)
        .password(this.password)
        .address(new Address(this.zipcode, this.city, this.district, this.detail))
        .phoneNumber(this.phoneNumber)
        .birth(new Birth(this.birth))
        .build();
  };

}
