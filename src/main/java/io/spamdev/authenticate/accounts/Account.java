package io.spamdev.authenticate.accounts;

import io.spamdev.authenticate.util.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends BaseEntity
{
    private String username;
    private String password;
    private String email;
}
