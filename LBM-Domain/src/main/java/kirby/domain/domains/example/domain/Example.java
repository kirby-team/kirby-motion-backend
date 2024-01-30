package kirby.domain.domains.example.domain;

import jakarta.persistence.*;
import kirby.domain.common.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "tbl_example")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Example extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  @Builder
  public Example(String content) {
    this.content = content;
  }
}
