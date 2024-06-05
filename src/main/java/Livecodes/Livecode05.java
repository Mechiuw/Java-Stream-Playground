package Livecodes;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Livecode05 {
    public static void run() {
        one();
        two();
        three();
        four();
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
        Arrays.stream(max).forEach(x -> System.out.print(x));
        System.out.println();
    }

    public static void four(){
        List<String> stringList = Arrays.asList("Ayam","Sapi","Anjing","Domba","Babi","Ayam","Domba");
        Map<String,Long> map = stringList.stream()
                .collect(Collectors.groupingBy(x -> x,Collectors.counting()));
        System.out.println();
        map.forEach((x,y) -> System.out.print(x + " - " + y + " || "));
    }


}
