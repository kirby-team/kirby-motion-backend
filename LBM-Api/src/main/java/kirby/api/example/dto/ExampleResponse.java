package kirby.api.example.dto;

import kirby.domain.domains.example.domain.Example;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExampleResponse {

  private final Long id;
  private final String content;

  public static ExampleResponse from(Example exampleEntity) {
    return new ExampleResponse(exampleEntity.getId(), exampleEntity.getContent());
  }
}
