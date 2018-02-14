package com.mycompany.app;

import java.math.BigDecimal;

public class CalculateRevenue implements RevenueCalculator
{
    public CalculateRevenue() {
    }

    public  BigDecimal calculateRevenue(BigDecimal marginPercentage, BigDecimal costOfGoods) {

        BigDecimal percentageDecimal = marginPercentage.divide(new BigDecimal(100));
        BigDecimal revenuePercentage = new BigDecimal(1).subtract(percentageDecimal);
        BigDecimal revenue = costOfGoods.divide(revenuePercentage);
        return revenue;
    }
}
