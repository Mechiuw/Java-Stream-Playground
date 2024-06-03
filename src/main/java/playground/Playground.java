package playground;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Playground {
    public static void run() {
        lib();
    }

    public static void lib(){
        streamOfCollection();
        streamOfArray();
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
        
    }
}
