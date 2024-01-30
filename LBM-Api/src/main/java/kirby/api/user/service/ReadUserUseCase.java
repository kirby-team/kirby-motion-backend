package kirby.api.user.service;

import kirby.api.common.util.UserUtils;
import kirby.common.annotation.UseCase;
import kirby.domain.common.vo.UserInfoVo;
import kirby.domain.domains.user.domain.User;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ReadUserUseCase {

  private final UserUtils userUtils;

  public UserInfoVo execute() {
    User currentUser = userUtils.getCurrentUser();
    return currentUser.toUserInfoVo();
  }
}
