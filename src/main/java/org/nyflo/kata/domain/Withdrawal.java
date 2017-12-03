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

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Withdrawal that = (Withdrawal) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        return dateTime != null ? dateTime.equals(that.dateTime) : that.dateTime == null;
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
