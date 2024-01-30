package kirby.common.exception;

import kirby.common.dto.ErrorReason;

public interface BaseErrorCode {

  public ErrorReason getErrorReason();

  String getExplainError() throws NoSuchFieldException;
}
