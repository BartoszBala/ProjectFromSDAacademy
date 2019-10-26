package pl.sda.inermediate;

import java.math.BigDecimal;

public class Customer {
static int  counter=1;
     int id;
    String firstname;
    String lastname;
    int age;
    BigDecimal salary;


    public Customer(String name, String surname, int age, BigDecimal salary) {
        this.id=counter;
        this.firstname = name;
        this.lastname = surname;
        this.age = age;
        this.salary = salary;
        this.counter++;
    }


}
