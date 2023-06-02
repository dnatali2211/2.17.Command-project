package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank bank = new Bank();

    @Test
    public void testAmountLowFromBalance() {

        Account accountFrom = new Account(800);
        Account accountTo = new Account(200);

        bank.transfer(accountFrom, accountTo, 799);

        Assertions.assertEquals(1, accountFrom.getBalance());
        Assertions.assertEquals(999, accountTo.getBalance());
    }

    @Test
    public void testAmountCurrentFromBalance() {

        Account accountFrom = new Account(800);
        Account accountTo = new Account(200);

        bank.transfer(accountFrom, accountTo, 800);

        Assertions.assertEquals(0, accountFrom.getBalance());
        Assertions.assertEquals(1000, accountTo.getBalance());
    }

    @Test
    public void testAmountHighFromBalance() {

        Account accountFrom = new Account(800);
        Account accountTo = new Account(200);

        bank.transfer(accountFrom, accountTo, 801);

        Assertions.assertFalse(false);
        Assertions.assertEquals(800, accountFrom.getBalance());
        Assertions.assertEquals(200, accountTo.getBalance());
    }

    @Test
    public void testAmountNegative() {

        Account accountFrom = new Account(800);
        Account accountTo = new Account(200);

        bank.transfer(accountFrom, accountTo, -500);

        Assertions.assertFalse(false);
        Assertions.assertEquals(800, accountFrom.getBalance());
        Assertions.assertEquals(200, accountTo.getBalance());
    }

    @Test
    public void testSuccessAmount() {

        Account accountFrom = new Account(800);
        Account accountTo = new Account(200);

        bank.transfer(accountFrom, accountTo, 400);

        Assertions.assertTrue(true);
        Assertions.assertEquals(400, accountFrom.getBalance());
        Assertions.assertEquals(600, accountTo.getBalance());
    }

    @Test
    public void testSuccessWhenFromLowTo() {

        Account accountFrom = new Account(400);
        Account accountTo = new Account(800);

        bank.transfer(accountFrom, accountTo, 200);

        Assertions.assertTrue(true);
        Assertions.assertEquals(200, accountFrom.getBalance());
        Assertions.assertEquals(1000, accountTo.getBalance());
    }

    @Test
    public void testFailedWhenFromNull() {

        Account accountFrom = new Account(0);
        Account accountTo = new Account(400);

        bank.transfer(accountFrom, accountTo, 200);

        Assertions.assertFalse(false);
        Assertions.assertEquals(0, accountFrom.getBalance());
        Assertions.assertEquals(400, accountTo.getBalance());
    }

    @Test
    public void testFailedWhenToNull() {

        Account accountFrom = new Account(800);
        Account accountTo = new Account(0);

        bank.transfer(accountFrom, accountTo, 200);

        Assertions.assertTrue(true);
        Assertions.assertEquals(600, accountFrom.getBalance());
        Assertions.assertEquals(200, accountTo.getBalance());
    }

    @Test
    public void testFailedWhenFromNegative() {

        Account accountFrom = new Account(-200);
        Account accountTo = new Account(400);

        bank.transfer(accountFrom, accountTo, 200);

        Assertions.assertFalse(false);
        Assertions.assertEquals(-200, accountFrom.getBalance());
        Assertions.assertEquals(400, accountTo.getBalance());
    }

    @Test
    public void testSuccessWhenToNegative() {

        Account accountFrom = new Account(800);
        Account accountTo = new Account(-200);

        bank.transfer(accountFrom, accountTo, 400);

        Assertions.assertTrue(true);
        Assertions.assertEquals(400, accountFrom.getBalance());
        Assertions.assertEquals(200, accountTo.getBalance());
    }

}

