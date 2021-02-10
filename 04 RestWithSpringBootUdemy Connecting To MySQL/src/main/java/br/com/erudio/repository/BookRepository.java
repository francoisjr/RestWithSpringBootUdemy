package br.com.erudio.repository;

import br.com.erudio.data.model.Book;
import br.com.erudio.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}