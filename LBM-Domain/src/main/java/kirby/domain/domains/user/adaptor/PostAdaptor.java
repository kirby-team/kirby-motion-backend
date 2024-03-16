package kirby.domain.domains.user.adaptor;

import kirby.common.annotation.Adaptor;
import kirby.domain.domains.user.domain.Post;
import kirby.domain.domains.user.exception.PostNotFoundException;
import kirby.domain.domains.user.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Adaptor
@RequiredArgsConstructor
public class PostAdaptor {
    private final PostRepository postRepository;

    public Post queryPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> PostNotFoundException.EXCEPTION);
    }
}
