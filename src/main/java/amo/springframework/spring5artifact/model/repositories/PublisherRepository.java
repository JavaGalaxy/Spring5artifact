package amo.springframework.spring5artifact.model.repositories;

import amo.springframework.spring5artifact.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
