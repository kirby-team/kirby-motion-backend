package kirby;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@RequiredArgsConstructor
@Slf4j
@SpringBootApplication
public class LbmApiApplication implements ApplicationListener<ApplicationReadyEvent> {

  private final Environment environment;

  public static void main(String[] args) {
    SpringApplication.run(LbmApiApplication.class, args);
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    log.info("applicationReady status" + Arrays.toString(environment.getActiveProfiles()));
  }
}