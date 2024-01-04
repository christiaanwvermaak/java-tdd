package com.cwvermaak.tdd.m4;

public class Position {
    Stock stock;
    int qty;
    double px;

    public Position(Stock stock, int qty, double px) {
        this.stock = stock;
        this.qty = qty;
        this.px = px;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQty() {
        return qty;
    }

    public double getAveragePx() {
        return px;
    }

    public double getValue() {
        return qty * px;
    }

    public void setQty(int newQty) {
        this.qty = newQty;
    }

    public void setAveragePx(double newAveragePx) {
        this.px = newAveragePx;
    }

    @Override
    public String toString() {
        return String.format("{ Stock[symbol=%s] | Qty: %s | Px: %s | Value: %s }", stock.symbol(), qty, px, getValue());
    }
}
