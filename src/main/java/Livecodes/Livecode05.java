package Livecodes;
import entities.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Livecode05 {
    public static void run() {
        one();
        two();
        three();
        four();
        five();
    }

    public static void one(){
        List<String> stringList = Arrays.asList("Ayam","Sapi","Anjing","Kucing","Babi","Kambing","Domba","Alpaka");
        List<String> findString = stringList.stream().filter(x -> x.startsWith("A")).sorted().toList();
        System.out.print("1) ");
        findString.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void two(){
        List<String> stringList = Arrays.asList("Ayam","Sapi","Anjing","Kucing","Babi","Kambing","Domba","Alpaka");
        int stringsLength = stringList.stream().mapToInt(String::length).sum() / stringList.size();
        System.out.print("2) average length : " + stringsLength);
        System.out.println();
    }

    public static void three(){
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,2,5,12,1,6);
        int[] max = integerList.stream()
                .mapToInt(x -> x * x).distinct().max().stream().toArray();
        System.out.print("3) found : ");
        Arrays.stream(max).forEach(System.out::print);
        System.out.println();
    }

    public static void four(){
        List<String> stringList = Arrays.asList("Ayam","Sapi","Anjing","Domba","Babi","Ayam","Domba");
        Map<String,Long> map = stringList.stream()
                .collect(Collectors.groupingBy(x -> x,Collectors.counting()));
        System.out.print("4) mapped : ");
        map.forEach((x,y) -> System.out.print(x + " - " + y + " || "));
        System.out.println();
    }

    public static void five(){
        List<Employee> employees = Arrays.asList(
                new Employee("randy",2000),
                new Employee("roland",4000),
                new Employee("bruce",3000),
                new Employee("joseph",2500));

        Integer threshold = 2800;
        List<Employee> filteredEmployees = employees.stream().filter(x -> x.getSalary() > threshold)
                .sorted(Comparator.comparingInt(Employee::getSalary)).toList();
        System.out.print("5) filtered employees salary above " + threshold + " : ");
        filteredEmployees.stream().map(Employee::getName).forEach(x -> System.out.print(x + ", "));
    }


}
