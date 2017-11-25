package amo.springframework.spring5artifact.model.repositories;

import amo.springframework.spring5artifact.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
