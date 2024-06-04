package Livecodes;

import entities.Customer;
import entities.Employee;
import entities.Students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Livecode03 {
    public static void run() {
        one();
        two();
        three();
        four();
        five();
    }
    public static void one(){
        List<Integer> numbers = Arrays.asList(293,1648,8364,18,247,937,1418,38);
        List<Integer> evenNum = numbers.stream().filter(x -> x % 2 == 0).sorted().toList();
        System.out.print("1) find even numbers " );
        evenNum.forEach(x -> System.out.print(evenNum + ","));
        System.out.println();
    }

    public static void two(){
        Employee employee1 = new Employee("esther",9000000);
        Employee employee2 = new Employee("sophia",8000000);
        Employee employee3 = new Employee("tyler",6000000);
        List<Integer> totalSalary = Arrays.asList(employee1.getSalary(),employee2.getSalary(),employee3.getSalary());
        int mean = totalSalary.stream().reduce(0,Integer::sum) / totalSalary.size();
        System.out.println("2) average employee salaries : " + mean);
    }

    public static void three(){
        List<Customer> customerList = Arrays.asList(
                new Customer("justin","america"),
                new Customer("andrew","japan"),
                new Customer("megan","america"),
                new Customer("annie","america"),
                new Customer("cynthia","indonesia"),
                new Customer("kai","japan"));

        Map<String, List<Customer>> a = customerList.stream().collect(Collectors.groupingBy(Customer::getCountry));
        System.out.print("3) filtered by country : ");
        a.forEach((country,customers) -> { String customerNames = customers.stream()
                .map(Customer::getName)
                .collect(Collectors.joining(","));
            System.out.println(country + " : " + customerNames + "\n");
        });
        System.out.println();
    }

    public static void four(){
        List<Students> students = Arrays.asList(
                new Students("andy","houston"),
                new Students("morgan","freeman"),
                new Students("aiden","pearce"),
                new Students("mike","zawolski"),
                new Students("carol","britten"));
        List<Students> sortedStudents = students.stream().sorted(Comparator.comparing(Students::getLastName)).toList();
        System.out.print("4) sorted by lastname : ");
        sortedStudents.stream().map(Students::getLastName).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void five(){
        List<String> stringList = Arrays.asList("alpha" ,"beta","charlie");
        List<String> uppercased = stringList.stream().map(String::toUpperCase).toList();
        System.out.print("5) UPPERCASED strings : ");
        uppercased.stream().map(String::toString).forEach(System.out::print);
    }
}
