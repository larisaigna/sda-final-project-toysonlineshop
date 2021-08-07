package com.larisaigna.sda.onlineshop.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "issue_date")
    private Timestamp issueDate;

    @Column(name = "due_date")
    private Timestamp dueDate;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "currency")
    private String currency;

    public Bill(Long id, Timestamp issueDate, Timestamp dueDate, Double amount, String currency) {
        this.id = id;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.currency = currency;
    }

    public Bill() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
