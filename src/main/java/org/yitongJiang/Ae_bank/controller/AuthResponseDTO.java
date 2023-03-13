package org.yitongJiang.Ae_bank.controller;

import lombok.*;
//jwt token
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
