package io.spamdev.authenticate.accounts;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AccountToUserDetails implements UserDetails
{
    private String username;
    private String password;

    //instance variables inherited from parent
    private boolean active;
    private List<GrantedAuthority> authorities;

    public AccountToUserDetails(Account account)
    {
        this.username = account.getUsername();
        this.password = account.getPassword();

        //hardcoded values
        this.active = true;
        this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        //hardcoded value
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String getUsername()
    {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return this.active;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return this.active;
    }

    @Override
    public boolean isEnabled()
    {
        return this.active;
    }
}
