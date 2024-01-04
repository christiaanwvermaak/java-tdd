package com.cwvermaak.tdd.m4;

import com.cwvermaak.tdd.m4.Stock;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private final Map<String, Position> positions;

    public Portfolio() {
        positions = new HashMap<>();
    }

    public  Map<String, Position> getAllPositions()
    {
        return positions;
    }

    public void add(Position position)
    {
        String symbol = position.getStock().symbol();

        if (positions.containsKey(symbol))
        {
            Position existingPosition = positions.get(symbol);
            int newQty = existingPosition.getQty() + position.getQty();
            double newAveragePrice = (existingPosition.getQty() * existingPosition.getAveragePx() +
                                      position.getQty() * position.getAveragePx()) / newQty;
            existingPosition.setQty(newQty);
            existingPosition.setAveragePx(newAveragePrice);
        } else {
            positions.put(symbol, position);
        }
    }

    public void add(String symbol, int qty, double px)
    {
        add(new Position(new Stock(symbol), qty, px));
    }

    public Position getPosition(String symbol)
    {
        return positions.get(symbol);
    }

    public double getTotalValue() {
        return positions.values().stream()
                .mapToDouble(Position::getValue)
                .sum();
    }

    public void print()
    {
        positions.values().forEach(System.out::println);
        System.out.println("==================================================");
        System.out.println(String.format("Portfolio value: %S", getTotalValue()));
    }

    public int getPositionCount()
    {
        return getAllPositions().size();
    }

    public void sell(String microsoft, int i) {
    }
}
