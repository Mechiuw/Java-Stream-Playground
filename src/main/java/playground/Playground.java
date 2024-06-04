package playground;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Playground {
    public static void run() {
        lib();
    }

    public static void lib(){
//        streamOfCollection();
//        streamOfArray();
//        streamBuilder();
//        streamGenerate();
//        streamIterate();
//        streamOfPrimitives();
//        streamOfString();
        streamOperations();
    }

    public static void streamOfCollection(){
        //EMPTY STREAM
        Stream<String> emptyStream = Stream.empty(); //.empty() to avoid null reference

        //STREAM OF COLLECTION
        Collection<String> collection = Arrays.asList("a","b","c");
        Stream<String> streamedCollection = collection.stream();
    }
    public static void streamOfArray(){
        //STREAM OF ARRAY
        Stream<String> alphabet = Stream.of("abc","def","ghi"); //one line array stream
        String[] arr = {"alpha","beta","charlie","echo","delta"};
        Stream<String> fullArr = Arrays.stream(arr);
        Stream<String> halfArr = Arrays.stream(arr,0,3); // returns alpha, beta and charlie
        Stream<String> endArr = Arrays.stream(arr,3,arr.length); // returns charlie, echo and delta

        System.out.println("full array: ");
        fullArr.forEach(System.out::println);
        System.out.println("half array : ");
        halfArr.forEach(System.out::println);
        System.out.println("end array: ");
        endArr.forEach(System.out::println);
    }

    public static void streamBuilder(){
        Stream<String> streamBuilderOne = Stream.<String>builder().add("dino").add("sau").add("rus").build();
        Stream<String> streamBuilderTwo = Stream.<String>builder().add("jalan").add("-").add("jalan").build();
        System.out.println("builder 1: ");
        streamBuilderOne.forEach(System.out::print);
        System.out.println("builder 2: ");
        streamBuilderTwo.forEach(System.out::print);
    }

    public static void streamGenerate(){
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(5); // this can generate or renders
        streamGenerated.forEach(System.out::println);

        Stream<Integer> streamNum = Stream.generate(() -> 10).limit(2);
        streamNum.forEach(System.out::println);
    }

    public static void streamIterate(){
        Stream<Integer> streamIteratedOne = Stream.iterate(1,n -> n + 1).limit(5);
        Stream<Integer> streamIteratedTwo = Stream.iterate(1,n -> n + 2).limit(5);
        Stream<Integer> streamIteratedThree = Stream.iterate(0,n -> n + 2).limit(5);
        System.out.println("urut: ");
        streamIteratedOne.forEach(System.out::print);
        System.out.println("\nganjil: ");
        streamIteratedTwo.forEach(System.out::print);
        System.out.println("\ngenap: ");
        streamIteratedThree.forEach(System.out::print);
    }

    public static void streamOfPrimitives(){
        IntStream intStreamEx = IntStream.range(1,5); // .range(int starts exclusive, int ends exclusive)
        IntStream intStreamIn = IntStream.rangeClosed(1,5); // .range(int starts inclusive, int ends inclusive)
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(2);

        System.out.println("stream of primitive exclusive .range() : ");
        intStreamEx.forEach(System.out::print);
        System.out.println("\nstream of primitive inclusive .rangeClosed() : ");
        intStreamIn.forEach(System.out::print);
        System.out.println("\nstream of primitive double stream .doubles() : ");
        doubleStream.forEach(System.out::print);
    }

    public static void streamOfString(){
        IntStream streamOfChars = "AaBbCcDd".chars(); //
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a.b,c"); // split it using regex validation
        System.out.println("Stream of chars : ");
        streamOfChars.forEach(System.out::print);
        System.out.println("\nStream of String :");
        streamOfString.forEach(System.out::print);

    }

    public static void streamOperations(){
        //filter() , sorted()
        Collection<Integer> intCollection = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> streamedInt = intCollection.stream().filter(x -> x % 2 ==0).sorted();
        System.out.println("stream odd numbers : \n");
        streamedInt.forEach(System.out::print);

        //flatMap() strings
        Collection<String> strCollections = Arrays.asList("ab","cd","ef","gh","ij","kl");
        System.out.println("\none-lined streams of chars: ");
        strCollections.stream().flatMap(x -> x.chars().mapToObj(c -> (char) c)).forEach(System.out::print);

        //flatmap integers
        Collection<Collection<Integer>> listCollections = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6));
        List<Integer> flattenedList = listCollections.stream().flatMap(Collection::stream).toList();
        System.out.println("\none-lined streams of integers:");
        flattenedList.forEach(System.out::print);

        //sequential processing (sum)
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream()
                .reduce(0,Integer::sum);
        System.out.println("\nsum: " + sum);

        //parallel processing (sum)
        int sums = numbers.parallelStream()
                .reduce(0,Integer::sum);
        System.out.println("parallel-sum: " + sums);

        //using reduce
        int z = numbers.stream().reduce(0,Integer::sum);
        System.out.println("z sum : " +z);

        //using reduce #2 (find maximum)
        int x = numbers.stream().reduce(0,Integer::max);
        System.out.println("max of numbers: " + x);

        //using reduce #3 (compare length)
        Collection<String> example = Arrays.asList("great","good","better","okay","nice");
        Optional<String> i = example.stream().reduce((word1,word2) -> word1.length() > word2.length() ? word1 : word2);
        System.out.print("check : ");
        i.ifPresent(System.out::print);

        //using sorted (alphabetically)
        List<String> sortedExample = example.stream().sorted().toList();
        System.out.print("\nsorted example: ");
        sortedExample.forEach(System.out::print);

        //sorted by length
        List<String> sortedInOrder = example.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.print("\nsorted example by length: ");
        sortedInOrder.forEach(System.out::print);

        //sorted both
        List<String> listedBoth = example.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).toList();
        System.out.print("\nsorted both:  ");
        listedBoth.forEach(System.out::print);

        //append characters
        List<String> vowels = Arrays.asList("i","e","o","u","a");
        List<String> xx = vowels.stream().sorted().toList();

        StringBuilder built = xx.parallelStream().collect(StringBuilder::new,(ss,hh) -> ss.append(hh),(kk,ll) -> kk.append(",").append(ll));
        StringBuilder builtByCorrection = vowels.parallelStream().collect(StringBuilder::new,(ss,hh) -> ss.append(hh),(kk,ll) -> kk.append(",").append(ll));

        System.out.println("\nappended coma alphabetically : " + built);
        System.out.println("appended coma natural/hard-code corrections : " + builtByCorrection);

        //anyMatch returns boolean
        String exs = "a";
        boolean matchVowel = vowels.stream().anyMatch(n -> n.equals(exs));
        String response = matchVowel ? "\"responded as found vowel\"" : "\"responded not found any\"";
        System.out.println(response);

        //count index or use count
        String word = "dawdidonawadiawdawdwadwadowafhaf";
        List<String> splittedWord = word.chars().mapToObj(e -> String.valueOf((char)e)).toList();
        System.out.println("counted : " + splittedWord.size() + " [" + word + "] ");

    }
}
