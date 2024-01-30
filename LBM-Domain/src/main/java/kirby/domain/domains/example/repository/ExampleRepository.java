package kirby.domain.domains.example.repository;

import kirby.domain.domains.example.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Long> {}
