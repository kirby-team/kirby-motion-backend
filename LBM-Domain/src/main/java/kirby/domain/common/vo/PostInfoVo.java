package kirby.domain.common.vo;

import kirby.domain.domains.user.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostInfoVo {
    private final Long postId;

    public static PostInfoVo from (Post post) {
        return PostInfoVo.builder().postId(post.getPostId()).build();
    }
}
