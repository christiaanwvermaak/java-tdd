package com.cwvermaak.tdd.m4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PortfolioPositionTest {
    @Test
    public void emptyPortfolio_zeroPositions()
    {
        var portfolio = new Portfolio();
        portfolioReturnsExpectedPositionCount(portfolio, 0);
    }

    @Test
    public void portfolioWithOnePosition_ReturnsThatPosition()
    {
        var portfolio = new Portfolio();

        String symbol = "MSFT";

        portfolio.add(new Position(new Stock(symbol), 10, 260));
        Assertions.assertEquals(1, portfolio.getAllPositions().size());

        Assertions.assertEquals(10, portfolio.getPosition(symbol).getQty()); // Confirms that the quantity is correct
        Assertions.assertEquals(260, portfolio.getPosition(symbol).getAveragePx()); // Confirms that the price is correct
        Assertions.assertEquals(2600, portfolio.getPosition(symbol).getValue()); // Confirms that the value is correct
    }

    @Test
    public void portfolioWithTwoDifferentPositions_ReturnsThosePositions()
    {
        var portfolio = new Portfolio();
        String microsoft = "MSFT";
        String apple = "AAPL";

        portfolio.add(new Position(new Stock(microsoft), 10, 260));
        portfolio.add(new Position(new Stock(apple), 2, 150));

        Assertions.assertEquals(2, portfolio.getAllPositions().size());

        // msft
        var microsoftPosition = portfolio.getPosition(microsoft);
        Assertions.assertEquals(10, microsoftPosition.getQty()); // Confirms that the quantity is correct
        Assertions.assertEquals(260, microsoftPosition.getAveragePx()); // Confirms that the price is correct
        Assertions.assertEquals(2600, microsoftPosition.getValue()); // Confirms that the value is correct

        // aapl
        var applePosition = portfolio.getPosition(apple);
        Assertions.assertEquals(2, applePosition.getQty()); // Confirms that the quantity is correct
        Assertions.assertEquals(150, applePosition.getAveragePx()); // Confirms that the price is correct
        Assertions.assertEquals(300, applePosition.getValue()); // Confirms that the value is correct
    }

    @Test
    public void portfolioWithSameStock_ReturnsOnePosition()
    {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";

        portfolio.add(new Position(new Stock(microsoft), 10, 260));
        portfolio.add(new Position(new Stock(microsoft), 5, 200));

        portfolioReturnsExpectedPositionCount(portfolio, 1);
    }

    @Test
    public void portfolioWithSameStock_ReturnsCorrectQty()
    {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";

        portfolio.add(new Position(new Stock(microsoft), 10, 260));
        portfolio.add(new Position(new Stock(microsoft), 1, 200));

        Assertions.assertEquals(11, portfolio.getPosition(microsoft).getQty());
    }

    @Test
    public void portfolioWithSameStock_ReturnCorrectAveragePrice()
    {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";
        portfolio.add(microsoft, 1, 240);
        portfolio.add(microsoft, 1, 220);

        Assertions.assertEquals(230, portfolio.getPosition(microsoft).getAveragePx());
    }

    @Test
    public void portfolioWithSameStock_ReturnCorrectPositionValue()
    {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";
        portfolio.add(microsoft, 2, 240);
        portfolio.add(microsoft, 1, 220);
        double expectedValue = 2 * 240 + 1 * 220;

        Assertions.assertEquals(expectedValue, portfolio.getPosition(microsoft).getValue());
    }

    @Test
    public void complexPortfolio_ReturnsCorrectTotalValue()
    {
        var portfolio = new Portfolio();

        portfolio.add("MSFT", 1, 260);
        portfolio.add("MSFT", 2, 250);

        portfolio.add("AAPL", 5, 90);
        portfolio.add("AAPL", 10, 80);

        portfolio.add("ORCL", 100, 80);

        portfolioReturnsExpectedPositionCount(portfolio, 3);
        Assertions.assertEquals(10010, portfolio.getTotalValue());
    }

    @Test
    public void portfolioSellStock_ReturnsCorrectPosition()
    {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";
        portfolio.add(microsoft, 2, 240);
        portfolio.add(microsoft, 1, 220);

        portfolio.sell(microsoft, 1);

        Assertions.assertEquals(3, portfolio.getPosition(microsoft).getQty());
    }


    private void portfolioReturnsExpectedPositionCount(Portfolio portfolio, int expectedCount) {
        Assertions.assertEquals(expectedCount, portfolio.getPositionCount());
    }

}
