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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public UserInfoVo toUserInfoVo() {
    return UserInfoVo.from(this);
  }
}
