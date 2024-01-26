package yuki.blet.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Embeddable
public class Birth {

  @Column(name = "birth", columnDefinition = "date")
  private LocalDate birth;

  public Birth() {};

  public Birth(LocalDate birth) {
    this.birth = birth;
  }

  public int getAge() {
    return LocalDate.now().getYear() - this.birth.getYear();
  }

  public String getStringBirth() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMDD");
    return this.birth.format(formatter);
  }

  public boolean validateExceedNow(LocalDate birth) {
    return this.birth.isAfter(LocalDate.now());
  }
}
