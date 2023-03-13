package org.yitongJiang.Ae_bank.model;

import jakarta.persistence.*;
import lombok.*;
//appointment get and setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String date;

}
