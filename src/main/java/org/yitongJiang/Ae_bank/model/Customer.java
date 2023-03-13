package org.yitongJiang.Ae_bank.model;


import org.yitongJiang.Ae_bank.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.Set;
//customer getter and setter and contrutor
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int accountNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private String password;
    @ManyToMany()
    @JoinTable(
            name = "credit_card_customer",
            joinColumns = @JoinColumn(name = "customer__id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="credit_card_id",referencedColumnName = "id")
    )
    private Set<CreditCard> CreditSet;

    @OneToOne
    @JoinColumn(
            name = "users_id",
            referencedColumnName = "id"
    )
    @JsonIgnore
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    private CheckingAccount checkingAccount;
    @OneToOne(cascade = CascadeType.ALL)
    private SavingAccount savingAccount;

    public Customer(String name, String email, Long id) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


//    public Customer(long id, int accountNumber, String name, String email, String phoneNumber, String dateOfBirth, String password, Set<CreditCard> creditSet, CheckingAccount checkingAccount, SavingAccount savingAccount) {
//        this.id = id;
//        this.accountNumber = accountNumber;
//        this.name = name;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.dateOfBirth = dateOfBirth;
//        this.password = password;
//        CreditSet = creditSet;
//        this.checkingAccount = checkingAccount;
//        this.savingAccount = savingAccount;
//    }
}
