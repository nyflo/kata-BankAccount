package org.nyflo.kata;

import org.nyflo.kata.domain.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Bank {

    private final Map<Client, Account> accounts = new ConcurrentHashMap<>();

    private Account getAccount(Client client) {
        if (accounts.containsKey(client))
            return accounts.get(client);
        else {
            Account account = new Account();
            accounts.put(client, account);
            return account;
        }
    }

    public double getBalance(Client client) {
        return getAccount(client).getBalance();
    }

    public void makeDeposit(Client client, Deposit deposit) {
        getAccount(client).makeOperation(deposit);
    }

    public void makeWithdrawal(Client client, Withdrawal withdrawal) {
        getAccount(client).makeOperation(withdrawal);
    }

    public List<Operation> getHistory(Client client) {
        return getAccount(client).getOperations().stream().sorted(Comparator.comparing(Operation::getDateTime)).collect(Collectors.toList());
    }
}
