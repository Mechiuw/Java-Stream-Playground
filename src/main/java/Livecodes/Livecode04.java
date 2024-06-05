package Livecodes;

import entities.Branch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Livecode04 {


    private static final List<Branch> branchList = Arrays.asList(
            new Branch("Manggarai", parseDate("01-02-2022"),1000,10),
            new Branch("BSD",parseDate("02-01-2022"),750,19),
            new Branch("Ragunan",parseDate("05-01-2022"),375,12),
            new Branch("Pasar Minggu",parseDate("05-08-2022"),35,3),
            new Branch("Kebayoran",parseDate("20-02-2022"),803,20),
            new Branch("Kuningan",parseDate("12-02-2022"),397,13)
    );


    public static void run() {
        one();
        two();
        three();
        four();
        five();
    }
    public static void one(){
        int minOmset = branchList.stream().mapToInt(Branch::getOmset).min().orElseThrow();
        int maxOmset = branchList.stream().mapToInt(Branch::getOmset).max().orElseThrow();
        System.out.println("1a) minimum omset : " + minOmset );
        System.out.println("1b) maximum omset : " + maxOmset );
    }
    public static void two(){
        IntStream lessThanSix = branchList.stream().mapToInt(Branch::getOmset).filter(x -> x < 600);
        System.out.print("2) omset less than 600 : ");
        lessThanSix.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void three(){
        Optional<Date> dateMinTrx = branchList.stream().min(Comparator.comparing(Branch::getTotal_trx)).map(Branch::getPeriod);
        System.out.print("3) date with the most minimum : ");
        dateMinTrx.ifPresent(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void four(){
        Map<String,Integer> totalOmset =
                branchList.stream().collect(Collectors
                        .groupingBy(Branch::getOutlet,Collectors
                                .summingInt(Branch::getOmset)));
        Map<String,Integer> totalTrx =
                branchList.stream().collect(Collectors
                        .groupingBy(Branch::getOutlet, Collectors
                                .summingInt(Branch::getTotal_trx)));

        System.out.println("4a) total omset : ");
        totalOmset.forEach((x, y) -> System.out.print(x + " : " + y + " || "));
        System.out.println();
        System.out.println("4a) total transactions : ");
        totalTrx.forEach((x, y) -> System.out.print(x + " : " + y + " || "));
    }

    public static void five(){
        int totalAllOmset = branchList.stream().mapToInt(Branch::getOmset).sum();
        int totalAllTrx = branchList.stream().mapToInt(Branch::getTotal_trx).sum();

        System.out.println();
        System.out.println("5a) total all omsets : " + totalAllOmset);
        System.out.print("5a) total all transactions : " + totalAllTrx);
    }


    public static Date parseDate(String parseDate){
        try{
            return new SimpleDateFormat("dd-MM-yyyy").parse(parseDate);
        } catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }
}
