package com.larisaigna.sda.onlineshop.service;

import com.larisaigna.sda.onlineshop.model.Account;
import com.larisaigna.sda.onlineshop.model.Role;
import com.larisaigna.sda.onlineshop.repository.AccountRepository;
import com.larisaigna.sda.onlineshop.service.dto.AccountDTO;
import com.larisaigna.sda.onlineshop.service.mail.MailService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import java.util.Collections;

@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final MailService mailService;

    public AccountService(AccountRepository accountRepository, BCryptPasswordEncoder passwordEncoder, MailService mailService) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password!");
        }

        return new User(account.getUsername(), account.getPassword(), mapRolesToAuthorities(account.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role)
    {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

    public void createAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setUsername(accountDTO.getUsername());
        account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
        account.setCreationDate(Timestamp.from(Instant.now()));
        account.setRole(Role.USER);

        accountRepository.save(account);

        /*try {
            mailService.sendMail("office@toysshop.com", accountDTO.getUsername(), "account created", "thank you for your registration");
        } catch (MessagingException e) {
            e.printStackTrace();
        }*/
    }

    public Boolean accountExist(String username) {
        Account accountExisting = accountRepository.findByUsername(username);
        return accountExisting != null;
    }
}
