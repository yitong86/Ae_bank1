package org.yitongJiang.Ae_bank.controller;

import org.yitongJiang.Ae_bank.auth.*;
import org.yitongJiang.Ae_bank.auth.Role;
import org.yitongJiang.Ae_bank.auth.User;
import org.yitongJiang.Ae_bank.payload.AuthenticationResponse;
import org.yitongJiang.Ae_bank.payload.RegisterRequest;
import org.yitongJiang.Ae_bank.repositories.RoleRepository;
import org.yitongJiang.Ae_bank.repositories.UserRepository;
import org.yitongJiang.Ae_bank.security.JwtService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.yitongJiang.Ae_bank.auth.AuthenticationRequest;
import org.yitongJiang.Ae_bank.auth.AuthenticationService;

// authtication controller for log in and register
import static org.yitongJiang.Ae_bank.auth.ERole.USER;
@CrossOrigin
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

       // Role roles = roleRepository.findByName(USER).get();
          //user.setRoles(Collections.singleton(roles));


        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
