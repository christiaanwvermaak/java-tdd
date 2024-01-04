package com.cwvermaak.tdd.m4;

public record Stock(String symbol) {
    public Stock(String symbol) {
        if (symbol == null || symbol.isBlank()) {
            throw new IllegalArgumentException("Stock symbol cannot be null or blank");
        }
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
