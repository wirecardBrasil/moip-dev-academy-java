package br.com.moip.devacademy.library.controller;

import br.com.moip.devacademy.library.entity.Loan;
import br.com.moip.devacademy.library.repository.LoanRepository;
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
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable(value = "id") Long loanId) {
        return loanRepository.findById(loanId).get();
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanRepository.save(loan);
    }

    @PutMapping("/{id}")
    public Loan updateLoan(@PathVariable(value = "id") Long loanId, @RequestBody Loan loanDetails) {

        Loan loan = loanRepository.findById(loanId).get();

        loan.setDateBorrowed(loanDetails.getDateBorrowed());
        loan.setTimeLimit(loanDetails.getTimeLimit());
        loan.setFineAmount(loanDetails.getFineAmount());
        loan.setBook(loanDetails.getBook());
        loan.setPatron(loanDetails.getPatron());
        loan.setUser(loanDetails.getUser());

        loanRepository.save(loan);

        return loan;
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable(value = "id") Long loanId) {
        Loan Loan = loanRepository.findById(loanId).get();
        loanRepository.delete(Loan);
    }
}
