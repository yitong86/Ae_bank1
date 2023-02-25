package com.capstone.Ae_bank.controller;

import com.capstone.Ae_bank.auth.*;
import com.capstone.Ae_bank.exception.AppException;
import com.capstone.Ae_bank.payload.ApiResponse;
import com.capstone.Ae_bank.payload.AuthenticationResponse;
import com.capstone.Ae_bank.payload.LoginRequest;
import com.capstone.Ae_bank.payload.RegisterRequest;
import com.capstone.Ae_bank.repositories.RoleRepository;
import com.capstone.Ae_bank.repositories.UserRepository;
import com.capstone.Ae_bank.security.JwtService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import static com.capstone.Ae_bank.auth.ERole.USER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private JwtService jwtGenerator;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        //return ResponseEntity.ok(new AuthenticationResponse(token));
       return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        Role roles = roleRepository.findByName(USER).get();
        user.setRoles(Collections.singleton(roles));


        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}