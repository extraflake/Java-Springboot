package com.batm.Day2.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MyUserDetails implements UserDetails {
    private String username;
    private String password;
    private GrantedAuthority grantedAuthority;

    public MyUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.grantedAuthority = new SimpleGrantedAuthority(user.getRole().getName());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        grantedAuthoritySet.add(getGrantedAuthority());
        return grantedAuthoritySet;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
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
    public String getPassword() {
        return password;
    }

    public GrantedAuthority getGrantedAuthority() {
        return grantedAuthority;
    }
}
