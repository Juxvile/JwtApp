package com.jwtproject.JwtApp.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class JwtUser implements UserDetails {
    private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final boolean enabled;

    @JsonIgnore
    private final Date lastPasswordResetDate;
    @JsonIgnore
    private final Collection<? extends GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }
    @JsonIgnore
    @Override
    public String getUsername() {
        return username;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
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
        return enabled;
    }
}
