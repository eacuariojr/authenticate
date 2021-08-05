package io.spamdev.authenticate.security;

import io.spamdev.authenticate.accounts.Account;
import io.spamdev.authenticate.accounts.AccountRepository;
import io.spamdev.authenticate.accounts.AccountToUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbUserDetailsService implements UserDetailsService
{
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<Account> account = accountRepository.findByUsername(username);

        //TODO: figure out lambdas
        account.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return new AccountToUserDetails(account.get());

        //Tutorial's recommended solution
        //return account.map(AccountToUserDetails::new).get();
    }
}
