package kirby.domain.domains.user.exception;

import kirby.common.annotation.ExplainError;
import kirby.common.dto.ErrorReason;
import kirby.common.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Objects;

import static kirby.common.consts.LbmStatic.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum PostErrorCode implements BaseErrorCode {
    POST_NOT_FOUND(NOT_FOUND, "POST_404_1", "글을 찾을 수 없습니다.");

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
