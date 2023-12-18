package ru.sberbank.edu;

import static java.lang.Math.round;

public class Сalculation {
    private FinancialFields financialFields = null;
    private double profit;

    public double getProfit() {
        return profit;
    }

    public Сalculation(FinancialFields financialFields) {
        this.financialFields = financialFields;
        profit = this.financialFields.getSum() * Math.pow(1 + this.financialFields.getPercentage()/100, this.financialFields.getYears());
        profit = profit * 100;
        profit = Math.round(profit);
        profit = profit / 100;
    }

}
