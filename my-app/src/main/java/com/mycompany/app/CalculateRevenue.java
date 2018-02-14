package com.mycompany.app;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalculateRevenue implements RevenueCalculator
{
    public CalculateRevenue() {
    }

    public  BigDecimal calculateRevenue(BigDecimal marginPercentage, BigDecimal costOfGoods) {

        if (costOfGoods==null || marginPercentage==null || costOfGoods.doubleValue()<0 )
            throw new RuntimeException("Cannot calculate");

        if (costOfGoods.equals(new BigDecimal(0)) && !marginPercentage.equals(new BigDecimal(0))) {
            throw new RuntimeException("Cannot calculate");
        }


        BigDecimal percentageDecimal = marginPercentage.divide(new BigDecimal(100));
        BigDecimal revenuePercentage = new BigDecimal(1).subtract(percentageDecimal);
        BigDecimal revenue = costOfGoods.divide(revenuePercentage,2, BigDecimal.ROUND_HALF_UP);

        return revenue;
    }
}
