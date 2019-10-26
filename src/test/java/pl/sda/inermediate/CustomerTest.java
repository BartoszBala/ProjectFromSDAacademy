package pl.sda.inermediate;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
   public void name()
    {
        Customer customer = new Customer();
        Customer customer2 = new Customer();


        System.out.println(customer.toString());
        System.out.println(customer2.getId());

    }

}