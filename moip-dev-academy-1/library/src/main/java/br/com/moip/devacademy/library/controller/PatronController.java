package br.com.moip.devacademy.library.controller;

import br.com.moip.devacademy.library.entity.Patron;
import br.com.moip.devacademy.library.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leticia.alves on 04/04/18.
 */
@RestController
@RequestMapping("/patrons")
public class PatronController {

    @Autowired
    private PatronRepository patronRepository;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patron getPatronById(@PathVariable(value = "id") Long patronId) {
        return patronRepository.findById(patronId).get();
    }

    @PostMapping
    public Patron createPatron(@RequestBody Patron patron) {
        return patronRepository.save(patron);
    }

    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable(value = "id") Long patronId, @RequestBody Patron patronDetails) {

        Patron patron = patronRepository.findById(patronId).get();

        patron.setName(patronDetails.getName());
        patron.setPhone(patronDetails.getPhone());

        patronRepository.save(patron);

        return patron;
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable(value = "id") Long patronId) {
        Patron patron = patronRepository.findById(patronId).get();
        patronRepository.delete(patron);
    }
}
