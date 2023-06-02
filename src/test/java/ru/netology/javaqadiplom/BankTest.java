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

    @Test
    public void testAmountLowFromBalance() {
        Bank bank = new Bank();
        Account accountFrom = new Account(800);
        Account accountTo = new Account(200);

        bank.transfer(accountFrom, accountTo, 799);

        Assertions.assertEquals(1, accountFrom.getBalance());
        Assertions.assertEquals(999, accountTo.getBalance());
    }

    @Test
    public void testAmountCurrentFromBalance() {
        Bank bank = new Bank();
        Account accountFrom = new Account(800);
        Account accountTo = new Account(200);

        bank.transfer(accountFrom, accountTo, 800);

        Assertions.assertEquals(0, accountFrom.getBalance());
        Assertions.assertEquals(1000, accountTo.getBalance());
    }

    @Test
    public void testAmountHighFromBalance() {
        Bank bank = new Bank();
        Account accountFrom = new Account(800);
        Account accountTo = new Account(200);

        bank.transfer(accountFrom, accountTo, 801);

        Assertions.assertFalse(false);
        Assertions.assertEquals(800, accountFrom.getBalance());
        Assertions.assertEquals(200, accountTo.getBalance());
    }

    @Test
    public void testAmountNegative() {
        Bank bank = new Bank();
        Account accountFrom = new Account(800);
        Account accountTo = new Account(200);

        bank.transfer(accountFrom, accountTo, -500);

        Assertions.assertFalse(false);
        Assertions.assertEquals(800, accountFrom.getBalance());
        Assertions.assertEquals(200, accountTo.getBalance());
    }

    @Test
    public void testSuccessAmount() {
        Bank bank = new Bank();
        Account accountFrom = new Account(800);
        Account accountTo = new Account(200);

        bank.transfer(accountFrom, accountTo, 400);

        Assertions.assertTrue(true);
        Assertions.assertEquals(400, accountFrom.getBalance());
        Assertions.assertEquals(600, accountTo.getBalance());
    }

    @Test
    public void testSuccessWhenFromLowTo() {
        Bank bank = new Bank();
        Account accountFrom = new Account(400);
        Account accountTo = new Account(800);

        bank.transfer(accountFrom, accountTo, 200);

        Assertions.assertTrue(true);
        Assertions.assertEquals(200, accountFrom.getBalance());
        Assertions.assertEquals(1000, accountTo.getBalance());
    }

    @Test
    public void testFailedWhenFromNull() {
        Bank bank = new Bank();
        Account accountFrom = new Account(0);
        Account accountTo = new Account(400);

        bank.transfer(accountFrom, accountTo, 200);

        Assertions.assertFalse(false);
        Assertions.assertEquals(0, accountFrom.getBalance());
        Assertions.assertEquals(400, accountTo.getBalance());
    }

    @Test
    public void testFailedWhenToNull() {
        Bank bank = new Bank();
        Account accountFrom = new Account(800);
        Account accountTo = new Account(0);

        bank.transfer(accountFrom, accountTo, 200);

        Assertions.assertTrue(true);
        Assertions.assertEquals(600, accountFrom.getBalance());
        Assertions.assertEquals(200, accountTo.getBalance());
    }

    @Test
    public void testFailedWhenFromNegative() {
        Bank bank = new Bank();
        Account accountFrom = new Account(-200);
        Account accountTo = new Account(400);

        bank.transfer(accountFrom, accountTo, 200);

        Assertions.assertFalse(false);
        Assertions.assertEquals(-200, accountFrom.getBalance());
        Assertions.assertEquals(400, accountTo.getBalance());
    }

    @Test
    public void testSuccessWhenToNegative() {
        Bank bank = new Bank();
        Account accountFrom = new Account(800);
        Account accountTo = new Account(-200);

        bank.transfer(accountFrom, accountTo, 400);

        Assertions.assertTrue(true);
        Assertions.assertEquals(400, accountFrom.getBalance());
        Assertions.assertEquals(200, accountTo.getBalance());
    }

}

