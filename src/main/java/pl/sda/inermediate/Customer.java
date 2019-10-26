package pl.sda.inermediate;


import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
public class Customer {
    private static Integer counter = 1;
    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;
    private BigDecimal salary;

    {
        this.id = counter++;

    }



    public Customer(String name, String surname, int age, String salary) {


       this(name, surname, age, salary==null?0:Double.parseDouble(salary));

    }

    public Customer(String name, String surname, int age, double salary) {

        this.firstname = name;
        this.lastname = surname;
        this.age = age;
        this.salary = BigDecimal.valueOf(salary);

    }





    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }


}
