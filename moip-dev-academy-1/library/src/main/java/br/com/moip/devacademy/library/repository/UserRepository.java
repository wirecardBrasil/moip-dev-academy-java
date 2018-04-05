package br.com.moip.devacademy.library.repository;

import br.com.moip.devacademy.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by leticia.alves on 04/04/18.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(String role);
}