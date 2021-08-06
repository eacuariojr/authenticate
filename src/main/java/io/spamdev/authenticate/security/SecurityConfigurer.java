package io.spamdev.authenticate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter
{
    @Autowired
    private DbUserDetailsService dbUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    //Authentication (check user identity)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(dbUserDetailsService);
    }

    //Authorization (check user access)
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //TODO: understand whatever this mumbo jumbo means
//        http.csrf().disable()
//                .authorizeRequests().antMatchers("/authenticate").permitAll().
//                anyRequest().authenticated()
//                .and().sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll();

        http.authorizeRequests()
                .antMatchers("/profile").hasRole("USER")
                .antMatchers("/**", "/static/**").permitAll()
                .and().formLogin()
                .loginPage("/login").permitAll();
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        //replace with BCryptPasswordEncoder after testing
        return NoOpPasswordEncoder.getInstance();
    }

    //https://stackoverflow.com/questions/52243774/consider-defining-a-bean-of-type-org-springframework-security-authentication-au
    //fix for AuthenticationManager requiring bean. Problems when Spring 2.0 came out
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
