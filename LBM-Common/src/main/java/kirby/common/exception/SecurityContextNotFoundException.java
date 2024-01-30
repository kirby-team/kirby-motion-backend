package kirby.common.exception;

public class SecurityContextNotFoundException extends MzpCodeException {

  public static final MzpCodeException EXCEPTION = new SecurityContextNotFoundException();

  private SecurityContextNotFoundException() {
    super(GlobalErrorCode.SECURITY_CONTEXT_NOT_FOUND);
  }
}
