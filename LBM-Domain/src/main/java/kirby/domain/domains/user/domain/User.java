package kirby.domain.domains.user.domain;

import jakarta.persistence.*;
import kirby.domain.common.model.BaseTimeEntity;
import kirby.domain.common.vo.UserInfoVo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
public class User extends BaseTimeEntity {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "userId", nullable = false)
  private Integer userId;

  @Column(name = "token", nullable = false)
  private String token;

  @Column(name = "name", nullable = false)
  private String name;

  public UserInfoVo toUserInfoVo() {
    return UserInfoVo.from(this);
  }
}
