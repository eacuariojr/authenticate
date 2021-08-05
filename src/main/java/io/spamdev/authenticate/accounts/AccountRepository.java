package io.spamdev.authenticate.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Uses the default Spring JPA repository class
 * https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
 */

public interface AccountRepository extends JpaRepository<Account, Integer>
{

}
