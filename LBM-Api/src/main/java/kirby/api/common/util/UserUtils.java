package kirby.api.common.util;

import kirby.api.config.security.SecurityUtils;
import kirby.domain.domains.user.adaptor.UserAdaptor;
import kirby.domain.domains.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtils {

  private final UserAdaptor userAdaptor;

  public Long getCurrentUserId() {
    return SecurityUtils.getCurrentUserId();
  }

  public User getCurrentUser() {
    return userAdaptor.queryUser(getCurrentUserId());
  }
}
