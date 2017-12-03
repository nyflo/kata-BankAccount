package org.nyflo.kata;

import org.nyflo.kata.domain.Account;
import org.nyflo.kata.domain.Client;
import org.nyflo.kata.domain.Deposit;
import org.nyflo.kata.domain.Withdrawal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

    private final Map<Client, Account> accounts = new ConcurrentHashMap<>();

    public Account getAccount(Client client) {
        if (accounts.containsKey(client))
            return accounts.get(client);
        else {
            Account account = new Account();
            accounts.put(client, account);
            return account;
        }
    }

    public void makeDeposit(Client client, Deposit deposit) {
        getAccount(client).makeOperation(deposit);
    }

    public void makeWithdrawal(Client client, Withdrawal withdrawal) {
        getAccount(client).makeOperation(withdrawal);
    }
}
