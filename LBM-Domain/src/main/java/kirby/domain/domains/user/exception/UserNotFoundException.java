package kirby.domain.domains.user.exception;

import kirby.common.exception.MzpCodeException;

public class UserNotFoundException extends MzpCodeException {

  public static final MzpCodeException EXCEPTION = new UserNotFoundException();

  private UserNotFoundException() {
    super(UserErrorCode.USER_NOT_FOUND);
  }
}
