package kirby.common.exception;

public class SecurityContextNotFoundException extends LbmCodeException {

  public static final LbmCodeException EXCEPTION = new SecurityContextNotFoundException();

  private SecurityContextNotFoundException() {
    super(GlobalErrorCode.SECURITY_CONTEXT_NOT_FOUND);
  }
}
