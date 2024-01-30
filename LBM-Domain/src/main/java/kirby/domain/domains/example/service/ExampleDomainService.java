package kirby.domain.domains.example.service;

import kirby.common.exception.DynamicException;
import kirby.domain.domains.example.domain.Example;
import kirby.domain.domains.example.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExampleDomainService {

  private final ExampleRepository exampleRepository;

  public void exception() {
    throw new DynamicException(400, "에러코드", "메세지");
  }

  public Example query(Long id) {
    return exampleRepository
        .findById(id)
        .orElseThrow(() -> new DynamicException(400, "에러코드", "메세지"));
  }

  public Example save(String content) {
    Example build = Example.builder().content(content).build();
    return exampleRepository.save(build);
  }
}
