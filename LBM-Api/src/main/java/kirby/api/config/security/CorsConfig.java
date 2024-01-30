package kirby.api.config.security;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class CorsConfig {

  @Bean
  public CorsConfigurationSource corsFilter() {
    return request -> {
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowedHeaders(Collections.singletonList("*"));
      config.setAllowedMethods(Collections.singletonList("*"));
      config.setAllowedOriginPatterns(Collections.singletonList("*")); // ⭐️ 허용할 origin
      config.setAllowCredentials(true);
      return config;
    };
  }
}
