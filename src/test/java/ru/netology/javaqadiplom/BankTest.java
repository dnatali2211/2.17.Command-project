package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank = new Bank();

    @Test
    public void testSuccessTransferIfFromMoreTo() {

        Account accountFrom = new Account(10_000);
        Account accountTo = new Account(5_000);

        bank.transfer(accountFrom, accountTo, 2_000);

        Assertions.assertEquals(8_000, accountFrom.getBalance());
        Assertions.assertEquals(7_000, accountTo.getBalance());
    }

    @Test
    public void testSuccessTransferIfToMoreFrom() {

        Account accountFrom = new Account(5_000);
        Account accountTo = new Account(10_000);

        bank.transfer(accountFrom, accountTo, 2_000);

        Assertions.assertEquals(3_000, accountFrom.getBalance());
        Assertions.assertEquals(12_000, accountTo.getBalance());
    }

    @Test
    public void testShouldNotTransferIfFromZero() {

        Account accountFrom = new Account(0);
        Account accountTo = new Account(5_000);

        bank.transfer(accountFrom, accountTo, 2_000);

        Assertions.assertEquals(0, accountFrom.getBalance());
        Assertions.assertEquals(5_000, accountTo.getBalance());
    }

    @Test
    public void testShouldTransferIfToZero() {

        Account accountFrom = new Account(10_000);
        Account accountTo = new Account(0);

        bank.transfer(accountFrom, accountTo, 2_000);

        Assertions.assertEquals(8_000, accountFrom.getBalance());
        Assertions.assertEquals(2_000, accountTo.getBalance());
    }

    @Test
    public void testShouldNotTransferAmountMoreThanBalanceFrom() {

        Account accountFrom = new Account(10_000);
        Account accountTo = new Account(5_000);

        bank.transfer(accountFrom, accountTo, 11_000);

        Assertions.assertEquals(10_000, accountFrom.getBalance());
        Assertions.assertEquals(5_000, accountTo.getBalance());
    }

    @Test
    public void testShouldNotTransferIfNegativeAmount() {

        Account accountFrom = new Account(10_000);
        Account accountTo = new Account(5_000);

        bank.transfer(accountFrom, accountTo, -1_000);

        Assertions.assertEquals(10_000, accountFrom.getBalance());
        Assertions.assertEquals(5_000, accountTo.getBalance());
    }

    @Test
    public void testShouldNotTransferIfNegativeFrom() {

        Account accountFrom = new Account(-10_000);
        Account accountTo = new Account(5_000);

        bank.transfer(accountFrom, accountTo, 1_000);

        Assertions.assertEquals(-10_000, accountFrom.getBalance());
        Assertions.assertEquals(5_000, accountTo.getBalance());
    }

    @Test
    public void testShouldTransferIfNegativeTo() {

        Account accountFrom = new Account(10_000);
        Account accountTo = new Account(-5_000);

        bank.transfer(accountFrom, accountTo, 1_000);

        Assertions.assertEquals(9_000, accountFrom.getBalance());
        Assertions.assertEquals(-4_000, accountTo.getBalance());
    }
}

