package io.spamdev.authenticate;

import io.spamdev.authenticate.accounts.AccountRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AccountRepository.class)
public class AuthenticateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticateApplication.class, args);
	}

}
