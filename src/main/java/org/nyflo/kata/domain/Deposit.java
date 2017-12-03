package org.nyflo.kata.domain;

import java.time.LocalDateTime;

public class Deposit implements Operation {

    private final LocalDateTime dateTime;
    private final double amount;

    public Deposit(final LocalDateTime dateTime, final double amount) {
        this.dateTime = dateTime;
        this.amount = amount;
    }

    public static Deposit of(final LocalDateTime dateTime, final double amount) {
        return new Deposit(dateTime, amount);
    }

    @Override
    public double getAmount() {
        return +amount;
    }
}
