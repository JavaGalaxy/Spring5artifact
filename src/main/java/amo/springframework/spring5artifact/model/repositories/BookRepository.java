package amo.springframework.spring5artifact.model.repositories;

import amo.springframework.spring5artifact.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {


}
