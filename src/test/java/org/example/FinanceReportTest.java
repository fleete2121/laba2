package org.example;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class FinanceReportTest extends TestCase {

    public void testGetCountPayments() {
        Payment[] payments = new Payment[]{
                new Payment("Иванов Иван Иванович", 3200, 10 ,11 , 2002),
                new Payment("Зыбенко Михаил Петрович", 4566, 2 ,10 , 2003)
        };
        FinanceReport fr = new FinanceReport(payments, "Петровна Лидия Григорьевна", 15, 12, 2002);
        int actual = fr.getCountPayments();
        int expected = 2;
        assertEquals(expected, actual);
    }

    public void testGetPayment() {
        Payment[] payments = new Payment[]{
                new Payment("Иванов Иван Иванович", 3200, 10 ,11 , 2002),
                new Payment("Зыбенко Михаил Петрович", 4566, 2 ,10 , 2003)
        };
        FinanceReport fr = new FinanceReport(payments, "Петровна Лидия Григорьевна", 15, 12, 2002);
        Payment payment = fr.getPayment(1);
        int actual = payment.getPaymentSum();
        int expected = 4566;
        assertEquals(expected, actual);
    }

    public void testSetPayment() {
        Payment[] payments = new Payment[]{
                new Payment("Иванов Иван Иванович", 3200, 10 ,11 , 2002),
                new Payment("Зыбенко Михаил Петрович", 4566, 2 ,10 , 2003)
        };
        FinanceReport fr = new FinanceReport(payments, "Петровна Лидия Григорьевна", 15, 12, 2002);
        fr.setPayment(1, new Payment(
                "Горшков Михаил Анатольевич", 12666, 10, 2 , 2023
        ));
        int actual = fr.getPayment(1).getPaymentSum();
        int expected = 12666;
        assertEquals(expected, actual);
    }

    public void testTestToString() {
        Payment[] payments = new Payment[]{
                new Payment("Иванов Иван Иванович", 3200, 10 ,11 , 2002),
                new Payment("Зыбенко Михаил Петрович", 4566, 2 ,10 , 2003)
        };
        FinanceReport fr = new FinanceReport(payments, "Петровна Лидия Григорьевна", 15, 12, 2002);
        Payment[] newPayments = fr.deepCopy();
        Payment actual = newPayments[0];
        Payment unexpected = fr.getPayment(0);
        assertNotSame(unexpected, actual);
        }
}
