package yuki.blet.domain.member;

import jakarta.persistence.Embeddable;
import java.lang.instrument.UnmodifiableClassException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import yuki.blet.global.domain.BaseEntity;

@Embeddable
@NoArgsConstructor
public class Address {

  private String zipcode;
  private String city;
  private String district;
  private String detail;

  public Address(String zipcode, String city, String district, String detail) {
    this.zipcode = zipcode;
    this.city = city;
    this.district = district;
    this.detail = detail;
  }

  public String getStringAddress() {
    return String.join(" ", List.of(zipcode, city, district, detail));
  }
}

