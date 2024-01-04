package com.cwvermaak.tdd.m4.firstAttempt;

import com.cwvermaak.tdd.m4.firstAttempt.Portfolio;
import com.cwvermaak.tdd.m4.firstAttempt.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PortfolioTests {
    @Test
    public void emptyPortfolio_hasZeroValue()
    {
        var portfolio = new Portfolio();
        Assertions.assertEquals(0, portfolio.totalValue());
    }

    @Test
    public void portfolioWithOneStockAdded_calculatesTotalValue()
    {
        int qty = 10;
        double px = 260;
        double value = px * qty;

        var portfolio = new Portfolio();
        portfolio.add(new Stock("MSFT", qty, px));
        Assertions.assertEquals(value, portfolio.totalValue());
    }

    @Test
    public void portfolioWithMultipleStocks_calculatesTotalValue()
    {
        // Stock 1
        int microsoftQty = 10;
        double microsoftPx = 260;
        double microsoftValue = microsoftQty * microsoftPx;
        
        // Stock 2
        int appleQty = 1;
        double applePx = 150;
        double appleValue = appleQty * applePx;

        var portfolio = new Portfolio();
        portfolio.add(new Stock("MSFT", microsoftQty, microsoftPx));
        portfolio.add(new Stock("AAPL", appleQty, applePx));

        Assertions.assertEquals(microsoftValue + appleValue, portfolio.totalValue());
    }

    @Test
    public void portfolioWithAddedStockAtDifferentPrices_calculateTotalValue()
    {
        // Stock - first entry
        int appleQty1 = 1;
        double applePx1 = 150;
        double appleValue1 = appleQty1 * applePx1;

        // Stock - second entry
        int appleQty2 = 2;
        double applePx2 = 100;
        double appleValue2 = appleQty2 * applePx2;

        var portfolio = new Portfolio();
        portfolio.add(new Stock("AAPL", appleQty1, applePx1));
        portfolio.add(new Stock("AAPL", appleQty2, applePx2));

        Assertions.assertEquals(appleValue1 + appleValue2, portfolio.totalValue());

    }
}
