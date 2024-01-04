package com.cwvermaak.tdd.m4.firstAttempt;

public class Stock {
    String symbol;
    int qty;
    double px;
    double totalValue;

    public Stock(String symbol, int qty, double px) {
        this.symbol = symbol;
        this.qty = qty;
        this.px = px;
    }

    public String getSymbol() {
        return symbol;
    }

    public double totalValue()
    {
        return qty * px;
    }
}
