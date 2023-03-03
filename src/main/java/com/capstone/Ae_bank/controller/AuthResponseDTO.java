package com.capstone.Ae_bank.controller;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private String token;
    private String tokenType = "Bearer ";
    private String username;


}
