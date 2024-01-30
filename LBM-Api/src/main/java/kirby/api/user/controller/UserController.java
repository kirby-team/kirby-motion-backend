package kirby.api.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import kirby.api.user.service.ReadUserUseCase;
import kirby.domain.common.vo.UserInfoVo;
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
@Tag(name = "1. [유저]")
public class UserController {

  private final ReadUserUseCase readUserUseCase;

  @Operation(summary = "내 유저 정보를 불러 옵니다.")
  @GetMapping("/me")
  public UserInfoVo getMyUserInfo() {
    return readUserUseCase.execute();
  }
}
