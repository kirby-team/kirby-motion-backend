package kirby.api.config.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kirby.common.dto.ErrorReason;
import kirby.common.dto.ErrorResponse;
import kirby.common.exception.BaseErrorCode;
import kirby.common.exception.DynamicException;
import kirby.common.exception.LbmCodeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(LbmCodeException.class)
  public ResponseEntity<ErrorResponse> LbmCodeExceptionHandler(
      LbmCodeException e, HttpServletRequest request) {
    BaseErrorCode code = e.getErrorCode();
    ErrorReason errorReason = code.getErrorReason();
    ErrorResponse errorResponse =
        new ErrorResponse(errorReason, request.getRequestURL().toString());
    return ResponseEntity.status(HttpStatus.valueOf(errorReason.getStatus())).body(errorResponse);
  }

  /** Request Param Validation 예외 처리 */
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> ConstraintViolationExceptionHandler(
      ConstraintViolationException e, HttpServletRequest request) {
    Map<String, Object> bindingErrors = new HashMap<>();
    e.getConstraintViolations()
        .forEach(
            constraintViolation -> {
              List<String> propertyPath =
                  List.of(constraintViolation.getPropertyPath().toString().split("\\."));
              String path =
                  propertyPath.stream().skip(propertyPath.size() - 1L).findFirst().orElse(null);
              bindingErrors.put(path, constraintViolation.getMessage());
            });

    ErrorReason errorReason =
        ErrorReason.builder()
            .code("BAD_REQUEST")
            .status(400)
            .reason(bindingErrors.toString())
            .build();
    ErrorResponse errorResponse =
        new ErrorResponse(errorReason, request.getRequestURL().toString());
    return ResponseEntity.status(HttpStatus.valueOf(errorReason.getStatus())).body(errorResponse);
  }

  @ExceptionHandler(DynamicException.class)
  public ResponseEntity<ErrorResponse> DynamicExceptionHandler(
      DynamicException e, HttpServletRequest request) {
    ErrorResponse errorResponse =
        new ErrorResponse(
            e.getStatus(), e.getCode(), e.getReason(), request.getRequestURL().toString());
    return ResponseEntity.status(HttpStatus.valueOf(e.getStatus())).body(errorResponse);
  }
}
