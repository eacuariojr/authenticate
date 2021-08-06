package io.spamdev.authenticate.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticateController
{
    @GetMapping("/login")
    public String serveLogin()
    {
        return "/security/login";
    }

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
}
