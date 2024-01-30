package kirby.domain.domains.user.adaptor;

import kirby.common.annotation.Adaptor;
import kirby.domain.domains.user.domain.User;
import kirby.domain.domains.user.exception.UserNotFoundException;
import kirby.domain.domains.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class UserAdaptor {

  private final UserRepository userRepository;

  public User queryUser(Long userId) {
    return userRepository.findById(userId).orElseThrow(() -> UserNotFoundException.EXCEPTION);
  }
}
