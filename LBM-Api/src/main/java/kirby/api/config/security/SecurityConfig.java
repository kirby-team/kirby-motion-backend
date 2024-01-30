package kirby.api.config.security;

import static kirby.common.consts.MzpStatic.SwaggerPatterns;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Value("${swagger.user}")
  private String swaggerUser;

  @Value("${swagger.password}")
  private String swaggerPassword;

  /**
   * 스웨거용 인메모리 유저 설정
   *
   * @return
   */
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user =
        User.withUsername(swaggerUser)
            .password(passwordEncoder().encode(swaggerPassword))
            .roles("SWAGGER")
            .build();
    return new InMemoryUserDetailsManager(user);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(8);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    String swaggerPattern = String.join(",", SwaggerPatterns);

    http.csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(
            (sessionManagement) ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .cors(AbstractHttpConfigurer::disable)
        .formLogin(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            (authorizeRequests) ->
                authorizeRequests
                    .requestMatchers(
                        new AntPathRequestMatcher(swaggerPattern),
                        new AntPathRequestMatcher("/v1/auth/**"),
                        new AntPathRequestMatcher("/v1/auth/token/refresh"))
                    .permitAll()
                    .anyRequest()
                    .permitAll()
            //            .hasRole("USER")
            );

    return http.build();
  }

  @Bean
  public RoleHierarchyImpl roleHierarchy() {
    RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
    roleHierarchy.setHierarchy("ROLE_SUPER_ADMIN > ROLE_ADMIN > ROLE_MANAGER > ROLE_USER");
    return roleHierarchy;
  }

  @Bean
  public DefaultWebSecurityExpressionHandler expressionHandler() {
    DefaultWebSecurityExpressionHandler expressionHandler =
        new DefaultWebSecurityExpressionHandler();
    expressionHandler.setRoleHierarchy(roleHierarchy());
    return expressionHandler;
  }
}
