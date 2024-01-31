package kirby.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@OpenAPIDefinition(
    info = @Info(title = "LogByMe App", description = "LogByMe API를 명세하는 문서", version = "0.0.1v"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

  @Bean
  public GroupedOpenApi appApi() {
    return GroupedOpenApi.builder().group("Lbm-app").pathsToMatch("/app/**").build();
  }

  @Bean
  public OpenAPI openAPI() {
    // SecuritySecheme명
    String jwtSchemeName = "jwtAuth";
    // API 요청헤더에 인증정보 포함
    SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
    // SecuritySchemes 등록
    Components components =
        new Components()
            .addSecuritySchemes(
                jwtSchemeName,
                new SecurityScheme()
                    .name(jwtSchemeName)
                    .type(SecurityScheme.Type.HTTP) // HTTP 방식
                    .scheme("bearer")
                    .bearerFormat("JWT")); // 토큰 형식을 지정하는 임의의 문자(Optional)

    return new OpenAPI().addSecurityItem(securityRequirement).components(components);
  }
}
