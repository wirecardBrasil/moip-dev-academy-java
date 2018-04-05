package br.com.moip.devacademy.library.runner;

import br.com.moip.devacademy.library.entity.User;
import br.com.moip.devacademy.library.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by leticia.alves on 04/04/18.
 */
@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Creating some users.....");

        repository.save(new User("Leticia", "ADM"));
        repository.save(new User("Matheus", "ADM"));
        repository.save(new User("Isaac", "LIB"));
        repository.save(new User("Allan", "LIB"));

        log.info("All users.....");

        for (User user : repository.findAll()) {
            log.info(user.toString());
        }

        log.info("Admin users are.....");
        log.info("____________________");
        for (User user : repository.findByRole("ADM")) {
            log.info(user.toString());
        }

        log.info("Librarian users are.....");
        log.info("____________________");
        for (User user : repository.findByRole("LIB")) {
            log.info(user.toString());
        }
    }
}