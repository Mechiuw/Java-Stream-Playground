package Livecodes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Livecode02 {
    public static void run() {
        one();
        two();
        three();
        four();
        five();
    }

    public static void one(){
        List<String> firstArr = Arrays.asList("one","two");
        List<String> secondArr = Arrays.asList("three","four");
        List<String> merged = Stream.concat(firstArr.stream(),secondArr.stream()).toList();
        System.out.print("1) ");
        merged.forEach(System.out::print);
        System.out.println();
    }

    public static void two(){
        String strings = "Alpha Beta Charlie Delta Echo Foxtrot Golf";
        List<String> a = Stream.of(strings.split(" ")).toList();
        System.out.println("2a) word counted : " + a.size());
        System.out.print("2b) length counted : ");
        a.stream().map(String::length).forEach(c -> System.out.print(c + "."));
        System.out.println();
    }

    public static void three(){
        String numbers = "632879931259";
        List<Integer> converted = numbers.chars().mapToObj(Character::getNumericValue).toList();
        System.out.print("3) line of numbers to prime numbers : ");
        converted.stream().filter(Livecode02::isPrime).sorted().forEach(c -> System.out.print(c + "."));
        System.out.println();
    }

    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        return IntStream.rangeClosed(2,(int) Math.sqrt(num)).noneMatch(i -> num % i == 0);
    }

    public static void four(){
        String numbers = "63287993125129470712731464217327939";
        List<Integer> converted = numbers.chars().mapToObj(Character::getNumericValue).toList();
        System.out.print("4a) inserted num : " + numbers + " \n4b) unique numbers : ");
        converted.stream().distinct().sorted().forEach(System.out::print);
        System.out.println();
    }

    public static void five(){
        String strings = "Foxtrot Charlie Beta Echo Charlie Alpha Beta Echo Delta Foxtrot Golf";
        Map<String,Long> a = Stream.of(strings.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("5) frequency : \n" + a);
    }
}
