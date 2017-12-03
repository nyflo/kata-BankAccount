package org.nyflo.kata.domain;

import java.time.LocalDateTime;

public class Withdrawal implements Operation {

    private final LocalDateTime dateTime;
    private final double amount;

    private Withdrawal(final LocalDateTime dateTime, final double amount) {
        if (amount > 0)
            throw new BankException("Withdrawal cannot be positive: " + amount);
        this.dateTime = dateTime;
        this.amount = amount;
    }

    public static Withdrawal of(final LocalDateTime dateTime, final double amount) {
        return new Withdrawal(dateTime, amount);
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
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
