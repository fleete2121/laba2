package org.example;

public class FinanceReport {
    Payment[] payments;
    String fullname;
    String paymentDate;

    public FinanceReport(Payment[] payments, String fullnameOfReportCreater, int day, int month, int year) {
        this.paymentDate = String.format("%d.%d.%d", day, month, year);
        this.fullname = fullnameOfReportCreater;
        this.payments = payments;
    }

    public int getCountPayments(){return payments.length;}
    public Payment getPayment(int numberOfPayment) throws ArrayIndexOutOfBoundsException{
        return payments[numberOfPayment];
    }

    public void setPayment(int numberOfPayment, Payment newValue) throws ArrayIndexOutOfBoundsException{
        payments[numberOfPayment] = newValue;
    }

    @Override
    public String toString() {
        String startReport = String.format("[Автор: %s, дата: %s, Платежи:[", fullname, paymentDate);
        StringBuilder paymentPartOfReport = new StringBuilder("\n");
        for (Payment payment:payments) {
            paymentPartOfReport.append(
                    String.format("\tПлательщик: %s, дата: %s, сумма: %d руб. %d коп.\n",
                    payment.getFIO(), payment.getPaymentDate(), payment.getPaymentSum() / 100, payment.getPaymentSum() % 100)
            );
        }
        paymentPartOfReport.delete(paymentPartOfReport.length() - 2, paymentPartOfReport.length());
        String completeReport = startReport + paymentPartOfReport.toString() + "]]";
        return completeReport;

    }
    public Payment copy(Payment payment){
        Payment newPayment = payment.clone();
        System.out.println(newPayment.equals(payment));
        return newPayment;
    }
    public Payment[] deepCopy(){
        Payment[] copyPayments = new Payment[payments.length];
        for (int i = 0; i < payments.length; i++) {
            copyPayments[i] = copy(payments[i]);
        }
        return copyPayments;
    }
}
