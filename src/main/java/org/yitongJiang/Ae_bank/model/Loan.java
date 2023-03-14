package org.yitongJiang.Ae_bank.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

//child class loan Account field and get and set
@Entity
@Builder
public class Loan extends Account {
    private String itemName;
    private int loanNumber;
    private double interestRateLoan;
    private String dueDate;


@ManyToOne
@JoinColumn(name = "customer_id", referencedColumnName = "id")
private Customer user;


    public Loan() {
    }

    public Loan(String itemName, int loanNumber, double interestRateLoan, String dueDate, Customer user) {
        super();
        this.itemName = itemName;
        this.loanNumber = loanNumber;
        this.interestRateLoan = interestRateLoan;
        this.dueDate = dueDate;
        this.user = user;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public double getInterestRateLoan() {
        return interestRateLoan;
    }

    public void setInterestRateLoan(double interestRateLoan) {
        this.interestRateLoan = interestRateLoan;
    }

    public Customer getCustomer() {
        return user;
    }

    public void setCustomer(Customer user) {
        this.user = user;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void withdraw(double amount){
        if(amount != 0){
            balance = balance - amount;

        }
    }

    public void deposit(double amount){
        if(amount != 0){
            balance = balance + amount;

        }
    }
}
