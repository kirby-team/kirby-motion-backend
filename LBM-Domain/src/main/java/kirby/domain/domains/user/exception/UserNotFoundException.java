package kirby.domain.domains.user.exception;

import kirby.common.exception.LbmCodeException;

public class UserNotFoundException extends LbmCodeException {

  public static final LbmCodeException EXCEPTION = new UserNotFoundException();

  private UserNotFoundException() {
    super(UserErrorCode.USER_NOT_FOUND);
  }
}
