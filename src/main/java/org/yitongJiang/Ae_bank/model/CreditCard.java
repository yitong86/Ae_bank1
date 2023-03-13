package org.yitongJiang.Ae_bank.model;


import org.yitongJiang.Ae_bank.enums.OperationType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;



import java.util.Set;

@Getter
@Setter
@Entity
public class CreditCard extends Account{


    private String cardNumber;
    private int cvv;
    private double amount;
    private String transactionDate;
    private String expireDate;


    private final OperationType type = OperationType.CREDIT;


@ManyToMany()
@JoinTable(
        name = "credit_card_customer",
        joinColumns = @JoinColumn(name="credit_card_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id",referencedColumnName = "id")
)
private Set<Customer> userSet;
    public CreditCard() {
    }

    public Set<Customer> getCustomerSet() {
        return userSet;
    }

    public void setCustomerSet(Set<Customer> userSet) {
        this.userSet = userSet;
    }

    public CreditCard(String cardNumber, int cvv, double amount, String transactionDate, String expireDate, Set<Customer> userSet) {
       super();
        super.setType(OperationType.CREDIT);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.expireDate = expireDate;
        this.userSet = userSet;

    }


    public void deposit(double amount){
        if(amount != 0){
            balance = balance + amount;

        }
    }
    public void withdraw(double amount){
        if(amount != 0){
            balance = balance - amount;

        }
    }



}

