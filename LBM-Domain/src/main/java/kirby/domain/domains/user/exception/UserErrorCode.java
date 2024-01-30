package kirby.domain.domains.user.exception;

import static kirby.common.consts.MzpStatic.NOT_FOUND;

import java.lang.reflect.Field;
import java.util.Objects;
import kirby.common.annotation.ExplainError;
import kirby.common.dto.ErrorReason;
import kirby.common.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements BaseErrorCode {
  USER_NOT_FOUND(NOT_FOUND, "USER_404_1", "유저 정보를 찾을 수 없습니다.");

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
