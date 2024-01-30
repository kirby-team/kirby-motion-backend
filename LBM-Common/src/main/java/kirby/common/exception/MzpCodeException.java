package kirby.common.exception;

import kirby.common.dto.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MzpCodeException extends RuntimeException {

  private BaseErrorCode errorCode;

  public ErrorReason getErrorReason() {
    return this.errorCode.getErrorReason();
  }
}
