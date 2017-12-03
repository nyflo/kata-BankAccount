package org.nyflo.kata.domain;

import java.time.LocalDateTime;

public class Deposit implements Operation {

    private final LocalDateTime dateTime;
    private final double amount;

    private Deposit(final LocalDateTime dateTime, final double amount) {
        if (amount < 0)
            throw new BankException("Deposit cannot be negative: " + amount);
        this.dateTime = dateTime;
        this.amount = amount;
    }

    public static Deposit of(final LocalDateTime dateTime, final double amount) {
        return new Deposit(dateTime, amount);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "dateTime=" + dateTime +
                ", amount=" + amount +
                '}';
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
