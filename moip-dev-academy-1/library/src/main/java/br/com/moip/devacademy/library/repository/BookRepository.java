package br.com.moip.devacademy.library.repository;

import br.com.moip.devacademy.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by leticia.alves on 04/04/18.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}