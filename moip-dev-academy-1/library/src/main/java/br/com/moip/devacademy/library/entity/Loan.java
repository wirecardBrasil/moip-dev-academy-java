package br.com.moip.devacademy.library.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by leticia.alves on 04/04/18.
 */
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateBorrowed;

    private Integer timeLimit;

    private Double fineAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    private Patron patron;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    protected Loan() {}

    public Loan(Date dateBorrowed, Integer timeLimit, Double fineAmount, Book book, Patron patron, User user) {
        this.dateBorrowed = dateBorrowed;
        this.timeLimit = timeLimit;
        this.fineAmount = fineAmount;
        this.book = book;
        this.patron = patron;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Date getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(Date dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "dateBorrowed=" + dateBorrowed +
                ", timeLimit=" + timeLimit +
                ", fineAmount=" + fineAmount +
                ", book=" + book +
                ", patron=" + patron +
                ", user=" + user +
                '}';
    }
}