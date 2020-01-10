package com.sys.service.impl;

import com.sys.dao.AccountDao;
import com.sys.entity.Account;
import com.sys.entity.Page;
import com.sys.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author y_zzu 2019-11-21-20:39
 */
@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public Account login(Account account) {
        return accountDao.login(account);
    }


}
