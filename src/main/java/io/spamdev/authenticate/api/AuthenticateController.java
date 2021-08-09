package io.spamdev.authenticate.api;

import io.spamdev.authenticate.accounts.Account;
import io.spamdev.authenticate.security.DbUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@Controller
public class AuthenticateController
{
    @Autowired
    DbUserDetailsService dbUserDetailsService;

    @GetMapping("/login")
    public String serveLogin()
    {
        return "/security/login";
    }

    //Currently unused
    //Overrides default spring security controller so user also gets jwt
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> verifyLogin(@PathVariable("username") String username,
                                         @PathVariable("password") String password) throws Exception
    {
        //verify login credentials with database
        //throw error if incorrect

        //if credentials are valid, return a jwt and refresh token

        return null;
    }

    @GetMapping("/signup")
    public String serveSignup()
    {
        return "/security/signup";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> performSignup(@RequestBody Account newAccount) throws ServerException
    {
        Account account = dbUserDetailsService.saveAccount(newAccount);

        if(account == null)
        {
            throw new ServerException("Signup failed");
        }
        else
        {
            return new ResponseEntity<>(account, HttpStatus.CREATED);
        }
    }
}
