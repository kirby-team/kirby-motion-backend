package kirby.api.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import kirby.domain.common.vo.PostInfoVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@SecurityRequirement(name = "access-token")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "2. [글]")
public class PostController {
    @Operation(summary = "글을 작성합니다.")
    @GetMapping("/post/write")
    public PostInfoVo writePost() {
        // TODO Controller 에서 글쓰기 구현
        return PostInfoVo.builder().build();
    }
}
