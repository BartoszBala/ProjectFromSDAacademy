package pl.sda.inermediate;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerStatisticsTest {

    @Test
    public void shouldGiveProperSalaryCustomersMap() {
        //given
        Map<BigDecimal, List<Customer>> bigDecimalListMap = CustomerStatistics.returnPersonWithSomeSalary();
    //when
      // System.out.println(bigDecimalListMap.toString());
       List<Customer>  customer =bigDecimalListMap.get(BigDecimal.valueOf(3333.0));
    //then
        assertEquals(2,customer.size());
}
}