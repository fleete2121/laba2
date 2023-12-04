package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Payment[] payments = new Payment[]{
                new Payment("Иванов Иван Иванович", 3200, 10 ,11 , 2002),
                new Payment("Зыбенко Михаил Петрович", 4566, 2 ,10 , 2003)
        };
        FinanceReport fr = new FinanceReport(payments, "Петровна Лидия Григорьевна", 15, 12, 2002);
        FinanceReportProcessor frp = new FinanceReportProcessor(fr);
        Payment[] paymentsSorted =  FinanceReportProcessor.getPaymentsPeopleSortedBySymbol("И");
        for (Payment paymentSorted : paymentsSorted) {
            System.out.println(paymentSorted.getFIO());
        }

        paymentsSorted =  FinanceReportProcessor.getPaymentsPeopleSortedByAmountPayment(5000);
        for (Payment paymentSorted : paymentsSorted) {
            System.out.println(paymentSorted.getPaymentSum());
        }
    }
}
