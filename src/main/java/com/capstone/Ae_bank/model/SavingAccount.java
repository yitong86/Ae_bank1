package com.capstone.Ae_bank.model;


import com.capstone.Ae_bank.enums.AccountStatus;
import com.capstone.Ae_bank.enums.OperationType;
import jakarta.persistence.Entity;
import lombok.Builder;

@Builder
@Entity
public class SavingAccount extends Account {
    private double interestRate;
    private double previousTransaction;
    private final OperationType type = OperationType.DEBIT;
    private final AccountStatus typeStatus = AccountStatus.ACTIVATED;


    public SavingAccount() {
    }

    public SavingAccount(double interestRate, double previousTransaction1) {

        super();
        super.setType(OperationType.DEBIT);
        this.interestRate = interestRate;
        this.previousTransaction = previousTransaction1;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }




    public void setPreviousTransaction(double previousTransaction) {
        this.previousTransaction = previousTransaction;
    }

    public double calcInterest(){
        return balance * interestRate;
    }

    public void applyInterest(){
        double interest = calcInterest();
        System.out.printf("Interest amount %.2f added to balance%n",interest);
        deposit(interest);
    }

    public void withdraw(double amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction  = -amount;
        }
    }

    public void deposit(double amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction  = amount;
        }
    }
    public void getPreviousTransaction() {
        if(previousTransaction >0){
            System.out.println("Deposited: " +previousTransaction);
        }else if(previousTransaction < 0){
            System.out.println("Withdraw: "+Math.abs(previousTransaction));
        }else{
            System.out.println("No transaction occurred");
        }


    }


}