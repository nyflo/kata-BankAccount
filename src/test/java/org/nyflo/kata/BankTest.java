package org.nyflo.kata;

import org.junit.Test;
import org.nyflo.kata.domain.Client;
import org.nyflo.kata.domain.Deposit;

import java.time.LocalDateTime;

import static org.assertj.core.api.BDDAssertions.then;

public class BankTest {

    private final Bank bank = new Bank();

    @Test
    public void bankClient_isCreated_automatically() {
        then(
                bank.getAccount(Client.of(1)).getBalance()
        ).isEqualTo(
                0
        );
    }

    @Test
    public void bankClient_can_makeOneDeposit() {
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 10.50d));
        then(
                bank.getAccount(Client.of(1)).getBalance()
        ).isEqualTo(
                10.50d
        );
    }

    @Test
    public void bankClient_can_makeSeveralOperations() {
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 10.50d));
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 5d));
        then(
                bank.getAccount(Client.of(1)).getBalance()
        ).isEqualTo(
                15.50d
        );
    }

    @Test
    public void severalBankClients_can_makeOperations() {
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 10d));
        bank.makeDeposit(Client.of(2), Deposit.of(LocalDateTime.now(), 100d));
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 20d));

        then(bank.getAccount(Client.of(1)).getBalance()).isEqualTo(30d);
        then(bank.getAccount(Client.of(2)).getBalance()).isEqualTo(100d);
    }

}
