package com.capstone.Ae_bank.controller;

import com.capstone.Ae_bank.auth.*;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.capstone.Ae_bank.auth.ERole.USER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtGenerator;



    private final AuthenticationService service;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtGenerator.generateToken(authentication);


        User userDetails = (User) authentication.getPrincipal();


        return ResponseEntity.ok(service.authenticate(request));
    }

    //    @PostMapping("/login")
//    public ResponseEntity<AuthenticationResponse> login(
//            @RequestBody AuthenticationRequest request
//    ) {
//        return ResponseEntity.ok(service.authenticate(request));
//    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        Role roles = roleRepository.findByName(USER).get();
          //user.setRoles(Collections.singleton(roles));


        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
