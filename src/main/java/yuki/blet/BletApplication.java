package yuki.blet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BletApplication {

  public static void main(String[] args) {
    SpringApplication.run(BletApplication.class, args);
  }

}
