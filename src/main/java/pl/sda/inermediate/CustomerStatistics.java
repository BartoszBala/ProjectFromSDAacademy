package pl.sda.inermediate;

import java.lang.invoke.ConstantCallSite;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomerStatistics {

    static Customer[] people = new Customer[]{
            new Customer("Anna", "Nowak   ", 33, "1200"),
            new Customer("Beata", "Kowalska", 22, "1200"),
            new Customer("Marek", " Nowak", 25, "1250 "),
            new Customer("Adam", "Twardowski", 33, "4100 "),
            new Customer("Monika  ", "Kos", 25, "2500"),
            new Customer("Adam ", "Rudy", 45, "3333"),
            new Customer("Marek", "Rudy", 15, 2210),
            new Customer("Adam", "Madej", 15, 3333),
            new Customer("Adam", "Nowak ", 15, null)
    };
//1. Napisz metodę, która zamieni tablicę people na listę people -
// ta metoda może być potem wykorzystywana przez Was w następnych metodach
/

    public static List<Customer> returnPeopleInList() {
        List<Customer> result = Arrays.stream(people).collect(Collectors.toList());

        result.stream().forEach(x -> {

            x.setFirstname(x.getFirstname().replaceAll("\\s+", ""));        //odrazu poprawiłem białe znaki przy wprowadzonych błednię imieniach i nazwiskach
            x.setLastname(x.getLastname().replaceAll("\\s+", ""));
        });


        return result;

    }
//2. Napisz metodę, która przyjmie tablicę people i
// zwróci listę Stringów <imię nazwisko> (elementem listy będzie np "Anna Nowak")


    public static List<String> giveCustomersNames() {
        List<String> result = new ArrayList<String>();

        for (Customer person : people) {                         //wywołanie for each
            String name = person.getFirstname() + " " + person.getLastname();
            result.add(name);
        }


        return result;


    }

    public static List<String> giveCustomersNamesWithStream() {
        List<String> result = new ArrayList<String>();

        return Arrays.stream(people).map(x -> x.getFirstname() + " " + x.getLastname()).collect(Collectors.toList());


    }

    //3. Napisz metodę, która zwróci mapę osób <id,osoba>

    public static Map<Integer, Customer> returnMapOfCustomer() {

        return returnPeopleInList().stream().collect(Collectors.toMap(x -> x.getId(), x -> x));

    }

//4. Napisz metodę, która zwróci mapę osób według zarobków <zarobki,osoby_z_zarobkami>

 public static Map<BigDecimal, List<Customer>> returnPersonWithSomeSalary() {

      return   returnPeopleInList().stream()
                .collect(Collectors.groupingBy(Customer::getSalary));



  }
    //5. Napisz metodę, która zwróci mapę ile jest osób z danymi zarobkami <zarobki, liczba_osób>


    public static Map<BigDecimal, Long> countPersonWithSomeSalary() {


        Map<BigDecimal, Long> result = returnPeopleInList().stream().collect(Collectors.groupingBy(Customer::getSalary, Collectors.counting()));

        return result;

    }



//6. Napisz metodę, która zwróci mapę map <imię,<zarobki, liczba_osób_z_takimi_zarobkami>>

    public static Map<String, Map<BigDecimal, Long>> showAllSalaryWithCountOtherPersonWithThisSalary() {

        Map<BigDecimal, Long> map = countPersonWithSomeSalary();
        Map<BigDecimal, Long> map1;
        Map<String, Map<BigDecimal, Long>> result = new HashMap<>();
        for (Customer person : people) {


            for (BigDecimal s : map.keySet()) {

                if (result.containsKey(person.getFirstname())) {

                    for (BigDecimal bd : map.keySet()) {

                        if (bd == person.getSalary()) {
                            result.get(person.getFirstname()).put(bd, map.get(bd));
                        }
                    }
                } else {
                    for (BigDecimal bd : map.keySet()) {

                        if (bd == person.getSalary()) {
                            map1 = new HashMap<>();
                            map1.put(bd, map.get(bd));
                            result.put(person.getFirstname(), map1);

                        }

                    }


                }

            }


        }

        return result;


    }

//7. Napisz metodę, która zwróci mapę <imię,<suma_zarobków_osób_o_taki_imieniu>>

    public static Map<String, BigDecimal> giveSumOfSalaryByName() {
        Map<String, BigDecimal> result = new HashMap<>();

        for (Customer person : people) {
            if (result.containsKey(person.getFirstname())) {
                BigDecimal salarySum = result.get(person.getFirstname());

                BigDecimal newsalary = salarySum.add(person.getSalary());

                result.put(person.getFirstname(), newsalary);
            } else {
                result.put(person.getFirstname(), person.getSalary());


            }


        }
        return result;


    }


    public static Map<String, Optional<BigDecimal>> giveSumOfSalaryByNameByStream() {


        Map<String, Optional<BigDecimal>> result =
                returnPeopleInList().stream().collect(Collectors.groupingBy(x -> x.getFirstname(),
                        Collectors.mapping(e -> e.getSalary(),
                                Collectors.reducing((a, b) -> a.add(b)))));

        return result;
    }


    public static void main(String[] args) {
        CustomerStatistics customer = new CustomerStatistics();

        List<Customer> list = CustomerStatistics.returnPeopleInList();
        // System.out.println(giveSumOfSalaryByName().toString());
        System.out.println(giveSumOfSalaryByNameByStream().toString());
        System.out.println(list.toString());


      //  System.out.println(CustomerStatistics.returnPersonWithSomeSalary().toString());
        System.out.println(CustomerStatistics.countPersonWithSomeSalary());

        System.out.println(showAllSalaryWithCountOtherPersonWithThisSalary().toString());

    }
}
