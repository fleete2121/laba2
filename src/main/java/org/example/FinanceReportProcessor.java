package org.example;

import java.util.ArrayList;
import java.util.List;

public class FinanceReportProcessor {

    static FinanceReport financeReport;
    public FinanceReportProcessor(FinanceReport fr){
        financeReport = fr;
    }
    static Payment[] getPaymentsPeopleSortedBySymbol(String symbol){
        List<Payment> paymentsWithStartSymbolIntoSurname = new ArrayList<>();
        for (int i = 0; i < financeReport.getCountPayments(); i++){
            Payment personPayment = financeReport.getPayment(i);
            if (personPayment.getFIO().startsWith(symbol)){
                paymentsWithStartSymbolIntoSurname.add(personPayment.clone());
            }
        }
        return paymentsWithStartSymbolIntoSurname.toArray(new Payment[0]);
    }

    static Payment[] getPaymentsPeopleSortedByAmountPayment(int amount){
        List<Payment> paymentsWithAmount = new ArrayList<>();
        for (int i = 0; i < financeReport.getCountPayments(); i++){
            Payment personPayment = financeReport.getPayment(i);
            if (personPayment.getPaymentSum() < amount){
                paymentsWithAmount.add(personPayment.clone());
            }
        }
        return paymentsWithAmount.toArray(new Payment[0]);
    }
}
