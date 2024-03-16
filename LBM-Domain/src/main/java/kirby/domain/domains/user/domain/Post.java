package kirby.domain.domains.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kirby.domain.common.model.BaseTimeEntity;
import kirby.domain.common.vo.PostInfoVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post extends BaseTimeEntity {
    @Id
    @Column(name = "postId", nullable = false)
    private Long postId;

    @Column(name = "writer", nullable = false)
    private Integer writer;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "picture")
    private String picture;

    @Column(name = "video")
    private String video;

    public PostInfoVo toPostInfoVo() {
        return PostInfoVo.from(this);
    }
}