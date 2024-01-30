package kirby.domain.common.vo;

import kirby.domain.domains.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoVo {

  private final Long userId;

  public static UserInfoVo from(User user) {
    return UserInfoVo.builder().userId(user.getId()).build();
  }
}
