package com.mycompany.app;

/**
 * Created by toorap on 14/02/2018.
 */
import java.math.BigDecimal;

public interface RevenueCalculator {

    BigDecimal calculateRevenue(BigDecimal marginPercentage,BigDecimal costOfGoods);

}