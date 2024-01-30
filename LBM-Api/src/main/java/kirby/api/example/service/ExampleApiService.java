package kirby.api.example.service;

import kirby.api.example.dto.ExampleResponse;
import kirby.domain.domains.example.domain.Example;
import kirby.domain.domains.example.service.ExampleDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleApiService {

  private final ExampleDomainService exampleDomainService;

  public ExampleResponse getExample() {
    Example query = exampleDomainService.query(1L);

    return ExampleResponse.from(query);
  }

  public ExampleResponse createExample() {
    Example asdf = exampleDomainService.save("asdf");
    return ExampleResponse.from(asdf);
  }
}
