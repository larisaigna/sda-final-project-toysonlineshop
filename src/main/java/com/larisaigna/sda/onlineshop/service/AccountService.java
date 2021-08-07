package com.larisaigna.sda.onlineshop.service;

import com.larisaigna.sda.onlineshop.model.Account;
import com.larisaigna.sda.onlineshop.model.Role;
import com.larisaigna.sda.onlineshop.repository.AccountRepository;
import com.larisaigna.sda.onlineshop.service.dto.AccountDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public AccountService(AccountRepository accountRepository, BCryptPasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password!");
        }

        return new User(account.getUsername(), account.getPassword(), new ArrayList<>());
    }

    public void createAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setUsername(accountDTO.getUsername());
        account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
        account.setCreationDate(Timestamp.from(Instant.now()));
        account.setRole(Role.USER);

        accountRepository.save(account);
    }

    public Boolean accountExist(String username) {
        Account accountExisting = accountRepository.findByUsername(username);
        return accountExisting != null;
    }
}
