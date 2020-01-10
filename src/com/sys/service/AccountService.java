package com.sys.service;

import com.sys.entity.Account;

/**
 * @author y_zzu 2019-11-21-20:37
 */
public interface AccountService extends BaseService<Account> {
    public Account login(Account account);
}
