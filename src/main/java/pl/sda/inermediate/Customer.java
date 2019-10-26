package pl.sda.inermediate;

import java.math.BigDecimal;

public class Customer {
    static Integer counter = 1;
    Integer id;
    String firstname;
    String lastname;
    Integer age;
    BigDecimal salary;

    {      this.id = counter++;

    }

    public Customer() {

    }

    public Customer(String name, String surname, int age, String salary) {

        this(name,surname,age,Double.parseDouble(salary));

    }
    public Customer(String name, String surname, int age, double salary) {

        this.firstname = name;
        this.lastname = surname;
        this.age = age;
        this.salary = BigDecimal.valueOf(salary);

    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
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
