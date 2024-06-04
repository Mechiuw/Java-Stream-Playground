package Livecodes;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Livecode01 {
    public static void run() {
        one();
        two();
        three();
        four();
        five();
    }

    public static void one() {
        List<Integer> integersList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer filtered = integersList.stream().filter(x -> x % 2 == 0).reduce(0,Integer::sum);
        System.out.println("1) total : " + filtered);
    }
    public static void two(){
        List<String> listOfWords = Arrays.asList("words","calling","friends","wonder","seventeen","strangers");
        System.out.print("2) ");
        String result = listOfWords.stream().max(Comparator.comparing(String::length)).orElse(" ");
        System.out.print(result + "\n");
    }
    public static void three(){
        List<String> strings = Arrays.asList("words","calling","friends");
        System.out.print("3) ");
        strings.stream().mapToInt(String::length).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
    public static void four() {
        List<String> strings = Arrays.asList("drama", "tacocat", "rotator", "nusapenusa");
        List<String> result = strings.stream().filter(x -> x.contentEquals(new StringBuilder(x).reverse())).toList();
        System.out.println("4) result : " + result);
    }
    public static void five(){
        List<Integer> integersList = Arrays.asList(9,83,11,4,96,60,79,81,95,100);
        Optional<Integer> secondLargest = integersList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.print("5) ");
        secondLargest.ifPresent(System.out::print);
    }
}
