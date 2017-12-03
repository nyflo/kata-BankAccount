package org.nyflo.kata.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class DepositTest {

    @Test
    public void deposit_hasDate() {
        assertThat(
                Deposit.of(
                        LocalDateTime.of(2017, 12, 1, 12, 30, 10),
                        10
                ).getDateTime()
        ).isEqualTo(
                LocalDateTime.of(2017, 12, 1, 12, 30, 10)
        );
    }

    @Test
    public void deposit_hasAmount() {
        assertThat(
                Deposit.of(
                        LocalDateTime.of(2017, 12, 1, 12, 30, 10),
                        10
                ).getAmount()
        ).isEqualTo(
                10
        );
    }

    @Test
    public void depositAmount_cannotBeNegative() {
        Assertions.assertThatThrownBy(() -> Deposit.of(LocalDateTime.now(), -10));
    }

}