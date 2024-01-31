package kirby.api.example.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import kirby.api.example.docs.ExampleExceptionDocs;
import kirby.api.example.dto.ExampleResponse;
import kirby.api.example.service.ExampleApiService;
import kirby.common.annotation.ApiErrorExceptionsExample;
import kirby.common.annotation.DevelopOnlyApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
@SecurityRequirement(name = "access-token")
@Tag(name = "xx. [예시] 에러코드 문서화")
public class ExampleController {

  private final ExampleApiService exampleApiService;

  @GetMapping("/examples")
  @DevelopOnlyApi
  @ApiErrorExceptionsExample(ExampleExceptionDocs.class)
  public ExampleResponse getExample(@RequestParam(name = "id") Long id) {
    return exampleApiService.getExample(id);
  }
}
