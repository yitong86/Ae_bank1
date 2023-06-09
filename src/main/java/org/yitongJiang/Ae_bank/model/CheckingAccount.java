package org.yitongJiang.Ae_bank.model;


import org.yitongJiang.Ae_bank.enums.AccountStatus;
import org.yitongJiang.Ae_bank.enums.OperationType;
import jakarta.persistence.Entity;
import lombok.Builder;
//child class checkingAccount field and get and set
@Builder
@Entity
public class CheckingAccount extends Account {
    private double previousTransaction;
    private final AccountStatus typeStatus = AccountStatus.ACTIVATED;
    private final OperationType type = OperationType.DEBIT;
    public CheckingAccount(double previousTransaction){

        super();
        super.setType(OperationType.DEBIT);
        this.previousTransaction = previousTransaction;
    }

    public CheckingAccount() {
    }

    public void setPreviousTransaction(double previousTransaction) {
        this.previousTransaction = previousTransaction;
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
