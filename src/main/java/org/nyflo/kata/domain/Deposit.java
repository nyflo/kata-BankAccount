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

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deposit deposit = (Deposit) o;

        if (Double.compare(deposit.amount, amount) != 0) return false;
        return dateTime != null ? dateTime.equals(deposit.dateTime) : deposit.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dateTime != null ? dateTime.hashCode() : 0;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
