package Livecodes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Livecode06 {
    private static final List<String> lists = Arrays.asList(
            "armenia",
            "korea",
            "america",
            "japan",
            "thailand",
            "taiwan",
            "england",
            "russia",
            "alaska",
            "china"
    );
    public static void run() {
        one();
        two();
        three();
        four();
        five();
    }

    public static void one(){
        List<String> containsE = lists.stream().filter(x -> !x.contains("e")).toList();
        System.out.print("1) contains E : ");
        containsE.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void two(){
        String lengthMoreThan = lists.stream().filter(x -> x.length() > 5).findFirst().toString();
        System.out.print("2) find length greater than 5  : " + lengthMoreThan);
        System.out.println();
    }

    public static void three(){
        int counted = (int) lists.stream().filter(x -> x.startsWith("A")).count();
        System.out.print("3) counted elements starts with A : " + counted);
    }

    public static void four(){
        List<String> allUpperCase = lists.stream().map(String::toUpperCase).toList();
        System.out.println();
        System.out.print("4) mapped to uppercase : ");
        allUpperCase.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void five(){
        List<String> sorted = lists.stream().sorted((s1,s2) -> Integer.compare(s1.length(),s2.length())).toList();
        System.out.print("5) sorted country by length : ");
        sorted.stream().forEach(x -> System.out.print(x + " "));
    }
}
