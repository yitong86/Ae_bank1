package com.capstone.Ae_bank.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.security.PublicKey;
import java.util.*;
import java.util.stream.Collectors;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"
                }),@UniqueConstraint(columnNames = {
                "email"
        })
        })
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String username;
    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;
    @NotBlank
    @Size(max = 100)
    @JsonIgnore
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<ERole> role = new HashSet<>();
//private ERole role;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(var r:this.role){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(r.name());
            authorities.add(authority);
        }
        return authorities;
//        return Collections.singleton(authority);
        //          List.of(new SimpleGrantedAuthority(role.name()));
        // return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public String getUsername(){
        return username;
    }
    @Override
    public String getPassword(){
        return password;
    }
//    public static User create(User user) {
//        List<GrantedAuthority> authoritiesList = new ArrayList<>();
//        authoritiesList.add(new SimpleGrantedAuthority("user"));
//        return new User(user.getId(), user.getUsername(), user.getPassword(), authoritiesList);
//    }
}