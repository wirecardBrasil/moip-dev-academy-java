package br.com.moip.devacademy.library.repository;

import br.com.moip.devacademy.library.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by leticia.alves on 04/04/18.
 */
@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
}