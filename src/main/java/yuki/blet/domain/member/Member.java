package yuki.blet.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import yuki.blet.global.domain.BaseEntity;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  @Column(name = "member_name")
  private String name;

  @Column(name = "member_email", unique = true)
  private String email;

  @Column(name = "member_password")
  private String password;

  @Embedded
  private Birth birth;

  @Column(name = "phone_number", unique = true)
  private String phoneNumber;

  @Embedded
  private Address address;
}


