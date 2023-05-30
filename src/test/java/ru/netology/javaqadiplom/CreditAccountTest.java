package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {


    @Test
    public void shouldNotNegativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1,
                    1_000,
                    15);
        });
    }

    @Test
    public void shouldNotNegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    -1,
                    15);
        });
    }

    @Test
    public void shouldNotNegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    1_000,
                    -1);
        });
    }

    @Test
    public void shouldSuccessPayment() {

        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                15);

        account.pay(500);

        Assertions.assertEquals(9_500, account.getBalance());
    }

    @Test
    public void shouldNotPayIfAmountMoreCreditLimit() {

        CreditAccount account = new CreditAccount(
                1_000,
                10_000,
                15);

        Assertions.assertFalse(account.pay(15_000));
    }

    @Test
    public void shouldNotPayIfSumBalanceAndAmountSameCreditLimit() {

        CreditAccount account = new CreditAccount(
                1_000,
                10_000,
                15);

        Assertions.assertTrue(account.pay(11_000));
    }

    @Test
    public void shouldNotPayIfNegativeAmount() {

        CreditAccount account = new CreditAccount(
                1_000,
                10_000,
                15);

        Assertions.assertFalse(account.pay(-3_000));
    }

    @Test
    public void shouldAddToPositiveBalance() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeAmount() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertFalse(account.add(-2_000));
    }

    @Test
    public void shouldAddIfBalanceAboveZero() {

        CreditAccount account = new CreditAccount(
                13_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(16_000, account.getBalance());
    }

    @Test
    public void shouldAddIfBalanceBelowZero() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3_000);
        account.add(2_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test
    public void shouldCountYearChangeIfNegativeBalance() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(5_000);

        Assertions.assertEquals(-750, account.yearChange());
    }

    @Test
    public void shouldCountYearChangeIfPositiveBalance() {

        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCountYearChangeIfBalanceZero() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
}
