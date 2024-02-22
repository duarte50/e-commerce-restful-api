package io.github.duarte50.e_commerce_restful_api.entity;

import io.github.duarte50.e_commerce_restful_api.utils.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 25)
    private String name;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 72)
    private String password;
    @Column(length = 11, unique = true)
    private String phoneNumber;

    @Column(length = 8)
    private String cep;
    @Column(length = 50)
    private String neighborhood;
    @Column(length = 50)
    private String city;
    @Column(length = 2)
    private String uf;

    private String profilePicture;

    @Column(nullable = false)
    private int itemsSold;

    @OneToMany
    private Set<Rating> ratingsReceived;
    @OneToMany
    private Set<Rating> ratingsSent;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
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
}
