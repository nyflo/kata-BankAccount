package org.nyflo.kata.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WithdrawalTest {

    @Test
    public void withdrawal_hasDate() {
        assertThat(
                Withdrawal.of(
                        LocalDateTime.of(2017, 12, 1, 12, 30, 10),
                        -10
                ).getDateTime()
        ).isEqualTo(
                LocalDateTime.of(2017, 12, 1, 12, 30, 10)
        );
    }

    @Test
    public void withdrawal_hasAmount() {
        assertThat(
                Withdrawal.of(
                        LocalDateTime.of(2017, 12, 1, 12, 30, 10),
                        -10
                ).getAmount()
        ).isEqualTo(
               -10
        );
    }

    @Test
    public void withdrawalAmount_cannotBePositive() {
        assertThatThrownBy(() -> Withdrawal.of(LocalDateTime.now(), 10));
    }

}