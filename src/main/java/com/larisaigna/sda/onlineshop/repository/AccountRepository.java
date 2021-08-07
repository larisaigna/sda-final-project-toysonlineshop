package com.larisaigna.sda.onlineshop.repository;

import com.larisaigna.sda.onlineshop.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByUsername(String username);


}
