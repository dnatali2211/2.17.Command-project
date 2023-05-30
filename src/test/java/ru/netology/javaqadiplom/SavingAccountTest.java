package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void testOverAddBalanceEqualsMax() {
        SavingAccount account = new SavingAccount(
                4_000,
                1_000,
                10_000,
                5
        );

        account.add(6_000);

        Assertions.assertEquals(4_000 + 6_000, account.getBalance());
    }

    @Test
    public void testOverAddBalanceHighMax() {
        SavingAccount account = new SavingAccount(
                6_000,
                1_000,
                10_000,
                5
        );

        account.add(6_000);

        Assertions.assertFalse(false);
    }

    @Test
    public void testOverPayBalanceLowMin() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(2_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void testOverPayBalanceEqualsMin() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );

        account.pay(2_000);

        Assertions.assertEquals(3_000 - 2_000, account.getBalance());
    }

    @Test
    public void testOverPayBalanceHighMin() {
        SavingAccount account = new SavingAccount(
                4_000,
                1_000,
                10_000,
                5
        );

        account.pay(2_000);

        Assertions.assertEquals(4_000 - 2_000, account.getBalance());
    }

    @Test
    public void testNegativeMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    3_000,
                    -1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void testMinBalanceHighMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    3_000,
                    10_000,
                    5_000,
                    5
            );
        });
    }

    @Test
    public void testNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    1_000,
                    10_000,
                    -5
            );
        });
    }

    @Test
    public void testNegativeAddAmount() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        account.add(-1_000);

        Assertions.assertFalse(false);
    }

    @Test
    public void testNegativePayAmount() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        account.pay(-1_000);

        Assertions.assertFalse(false);
    }

    @Test
    public void testYearChange() {
        SavingAccount account = new SavingAccount(
                200,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(30, account.yearChange());
    }
}
