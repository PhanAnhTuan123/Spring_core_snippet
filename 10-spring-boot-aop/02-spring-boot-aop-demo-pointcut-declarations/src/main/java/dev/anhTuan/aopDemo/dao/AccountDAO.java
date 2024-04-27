package dev.anhTuan.aopDemo.dao;

import dev.anhTuan.aopDemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();

}
