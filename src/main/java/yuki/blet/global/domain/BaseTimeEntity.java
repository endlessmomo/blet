package yuki.blet.global.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

  @CreatedDate
  @Column(name = "created_at", updatable = false, columnDefinition = "datetime")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "updated_at", columnDefinition = "datetime")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public LocalDateTime updatedAt;
}
