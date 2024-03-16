package kirby.domain.domains.user.exception;

import kirby.common.exception.LbmCodeException;

public class PostNotFoundException extends LbmCodeException {
    public static final LbmCodeException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(PostErrorCode.POST_NOT_FOUND);
    }
}
