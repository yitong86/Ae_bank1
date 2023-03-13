package org.yitongJiang.Ae_bank.model;


import jakarta.persistence.Entity;
//child class loan Account field and get and set
@Entity
public class LoanPayment extends Loan{
    private Long monthlyPaymentAmount;
    private Long downPayment;
    private Long loanBalance;
    private String createdPaymentDate;

    public LoanPayment() {
    }

    public LoanPayment(Long monthlyPaymentAmount, Long downPayment, Long loanBalance, String createdPaymentDate) {
        super();
        this.monthlyPaymentAmount = monthlyPaymentAmount;
        this.downPayment = downPayment;
        this.loanBalance = loanBalance;
        this.createdPaymentDate = createdPaymentDate;
    }

    public Long getMonthlyPaymentAmount() {
        return monthlyPaymentAmount;
    }

    public void setMonthlyPaymentAmount(Long monthlyPaymentAmount) {
        this.monthlyPaymentAmount = monthlyPaymentAmount;
    }

    public Long getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(Long downPayment) {
        this.downPayment = downPayment;
    }

    public Long getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Long loanBalance) {
        this.loanBalance = loanBalance;
    }

    public String getCreatedPaymentDate() {
        return createdPaymentDate;
    }

    public void setCreatedPaymentDate(String createdPaymentDate) {
        this.createdPaymentDate = createdPaymentDate;
    }
}
