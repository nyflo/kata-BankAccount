package org.nyflo.kata;

import org.junit.Test;
import org.nyflo.kata.domain.Client;
import org.nyflo.kata.domain.Deposit;
import org.nyflo.kata.domain.Withdrawal;

import java.time.LocalDateTime;

import static org.assertj.core.api.BDDAssertions.then;

public class BankTest {

    private final Bank bank = new Bank();

    @Test
    public void bankClient_isCreated_automatically() {
        then(
                bank.getBalance(Client.of(1))
        ).isEqualTo(
                0
        );
    }

    @Test
    public void bankClient_can_makeOneDeposit() {
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 10.50d));
        then(
                bank.getBalance(Client.of(1))
        ).isEqualTo(
                10.50d
        );
    }

    @Test
    public void bankClient_can_makeSeveralOperations() {
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 10.50d));
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 5d));
        then(
                bank.getBalance(Client.of(1))
        ).isEqualTo(
                15.50d
        );
    }

    @Test
    public void severalBankClients_can_makeOperations() {
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 10d));
        bank.makeDeposit(Client.of(2), Deposit.of(LocalDateTime.now(), 100d));
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 20d));

        then(bank.getBalance(Client.of(1))).isEqualTo(30d);
        then(bank.getBalance(Client.of(2))).isEqualTo(100d);
    }

    @Test
    public void bankClient_can_makeWithrawal() {
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 100d));
        bank.makeWithdrawal(Client.of(1), Withdrawal.of(LocalDateTime.now(), -10d));
        then(
                bank.getBalance(Client.of(1))
        ).isEqualTo(
                90d
        );
    }

    @Test
    public void bankClient_can_makeWithrawalOfAllItsSavings() {
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.now(), 100d));
        bank.makeWithdrawal(Client.of(1), Withdrawal.of(LocalDateTime.now(), -100d));
        then(
                bank.getBalance(Client.of(1))
        ).isEqualTo(
                0d
        );
    }

    @Test
    public void bankClient_can_getOperationsHistory() {
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.of(2017, 11, 15, 12, 30), 100d));
        bank.makeDeposit(Client.of(1), Deposit.of(LocalDateTime.of(2017, 12, 1, 12, 30), 15d));
        bank.makeWithdrawal(Client.of(1), Withdrawal.of(LocalDateTime.of(2017, 11, 18, 12, 30), -50d));
        then(
                bank.getHistory(Client.of(1))
        ).containsExactly(
                Deposit.of(LocalDateTime.of(2017, 11, 15, 12, 30), 100d),
                Withdrawal.of(LocalDateTime.of(2017, 11, 18, 12, 30), -50d),
                Deposit.of(LocalDateTime.of(2017, 12, 1, 12, 30), 15d)
        );
    }

}
