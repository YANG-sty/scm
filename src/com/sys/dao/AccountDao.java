package com.sys.dao;

import com.sys.entity.Account;

public interface AccountDao extends BaseDao<Account> {
    //BaseDao 中的方法，无法满足登录的需要，自己定义。
    public Account login(Account account);
}