package kirby.api.example.docs;

import kirby.common.annotation.ExceptionDoc;
import kirby.common.annotation.ExplainError;
import kirby.common.exception.MzpCodeException;
import kirby.common.interfaces.SwaggerExampleExceptions;
import kirby.domain.domains.user.exception.UserNotFoundException;

@ExceptionDoc
public class ExampleExceptionDocs implements SwaggerExampleExceptions {

  @ExplainError("유저검색시에 안나올 때 나오는 에러입니다.")
  public MzpCodeException 유저없을때 = UserNotFoundException.EXCEPTION;
}
