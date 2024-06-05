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
//        two();
//        three();
//        four();
//        five();
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






    public static Date parseDate(String parseDate){
        try{
            return new SimpleDateFormat("dd-MM-yyyy").parse(parseDate);
        } catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }
}
