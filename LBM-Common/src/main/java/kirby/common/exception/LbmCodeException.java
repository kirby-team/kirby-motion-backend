package kirby.common.exception;

import kirby.common.dto.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LbmCodeException extends RuntimeException {

  private final BaseErrorCode errorCode;

  public ErrorReason getErrorReason() {
    return this.errorCode.getErrorReason();
  }
}
