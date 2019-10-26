package pl.sda.inermediate;

import java.math.BigDecimal;

public class CustomerStatistics {

    Customer[] people = new Customer[]{
            new Customer( "Anna", "Nowak   ", 33, new BigDecimal("1200")),
            new Customer( "Beata", "Kowalska", 22, new BigDecimal("1200")),
            new Customer( "Marek", " Nowak", 25, new BigDecimal("1500")),
            new Customer( "Adam", "Twardowski", 33, new BigDecimal("4100")),
            new Customer( "Monika  ", "Kos", 25, new BigDecimal("2500")),
            new Customer( "Adam ", "Rudy", 45, new BigDecimal("3333")),
            new Customer( "Marek", "Rudy", 15, new BigDecimal("2210")),
            new Customer( "Adam", "Madej", 15, new BigDecimal("3333")),
            new Customer( "Adam", "Nowak ", 15, null)
    };


}
