package kirby.domain.common.aop.domainEvent;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DomainEvent {

  private final LocalDateTime publishAt;

  public DomainEvent() {
    this.publishAt = LocalDateTime.now();
  }
}
