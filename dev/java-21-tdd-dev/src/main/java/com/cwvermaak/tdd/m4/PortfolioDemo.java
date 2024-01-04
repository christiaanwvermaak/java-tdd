package com.cwvermaak.tdd.m4;

public class PortfolioDemo
{
    public static void main( String[] args )
    {
        var portfolio = new Portfolio();
        portfolio.add("MSFT", 1, 260);
        portfolio.add("MSFT", 2, 250);
        portfolio.add("AAPL", 5, 90);
        portfolio.add("AAPL", 10, 80);
        portfolio.add("ORCL", 100, 80);

        portfolio.print();
    }

    private static Position position(String symbol, int qty, double px) {
        return new Position(new Stock(symbol), qty, px);
    }
}
