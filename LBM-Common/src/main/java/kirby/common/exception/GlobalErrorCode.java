package kirby.common.exception;

import static kirby.common.consts.LbmStatic.INTERNAL_SERVER;

import java.lang.reflect.Field;
import java.util.Objects;
import kirby.common.annotation.ExplainError;
import kirby.common.dto.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements BaseErrorCode {
  @ExplainError("500번대 알수없는 오류입니다. 서버 관리자에게 문의 주세요")
  INTERNAL_SERVER_ERROR(INTERNAL_SERVER, "GLOBAL_500_1", "서버 오류. 관리자에게 문의 부탁드립니다."),

  SECURITY_CONTEXT_NOT_FOUND(500, "GLOBAL_500_2", "security context not found");

  private Integer status;
  private String code;
  private String reason;

  @Override
  public ErrorReason getErrorReason() {
    return ErrorReason.builder().reason(reason).code(code).status(status).build();
  }

  @Override
  public String getExplainError() throws NoSuchFieldException {
    Field field = this.getClass().getField(this.name());
    ExplainError annotation = field.getAnnotation(ExplainError.class);
    return Objects.nonNull(annotation) ? annotation.value() : this.getReason();
  }
}
