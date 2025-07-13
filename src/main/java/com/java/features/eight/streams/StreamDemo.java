package com.java.features.eight.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class to demo stream Usage in Java
 */
public class StreamDemo {
	public static int  k = 0;
	public static int length = 0;
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>(0);
        strList.add("shashwat singh");
        strList.add("saurabh kaul");
        strList.add("sandeep kaul ");
        strList.add("smit singh");
        strList.add("shashank chaudhary");
        strList.add("divyanshu bhardwaj");
        strList.add("bhuvnesh krishna sinha");
        strList.add("sumit gupta");
        int i = 0;
        Stream<String> stream1 = strList.stream();
        strList.add("XXXXXXXXX");
        Map<Object, Object> strMap = stream1.filter(str->str.charAt(0)=='s').collect(Collectors.toMap(s->{return k++;}, p->p));
        System.out.println("Map:" + strMap); 
/**
 * Demo for forEach,collect,filter functions of stream
 */
        String str = "Hello Shashwat Hello How are you";
        Stream <String> stream = Arrays.asList( str.split(" ")).stream();
        Map<String,Integer> fMap = new HashMap<String,Integer>();
      
        stream.forEach(word->{
            Integer freq = fMap.get(word);
            if(null == freq){
                fMap.put(word,1);
            }else{
                fMap.put(word,++freq);
            }
        });

        Stream<String> fStream = fMap.keySet().stream();
        fStream.filter(key->fMap.get(key) >=2)
                .collect(Collectors.toList())
                .forEach(s->System.out.println(s +" :::: "+fMap.get(s)));

        Stream<String> stream2 = stream = Arrays.asList( str.split(" ")).stream();
        stream2.filter(p->p.charAt(0)=='H').forEach(p->{length+=p.length();});;
        System.out.println(length);

        /**
         * How would you count the frequency of characters in a String using Streams
         */

        String input = "Shashwat";
        Map<Character, Long> frequency = input.chars()
                .mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        frequency.entrySet().stream().forEach(p -> System.out.println(p));

        /**
         * How can you find the second highest number in a list
         */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> secondHighest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        System.out.println(secondHighest.get());

        /**
         * Stream demo ......
         */
        List<Integer> numbers1 = new ArrayList<Integer>();
        numbers1.add(22);
        numbers1.add(23);
        numbers1.add(24);
        Stream<Integer> numStream = numbers1.stream();
        //numbers1.add(21);
        numStream.forEach(p -> System.out.println(p));
        numbers1.add(21);

        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream3 = stringList.stream();

        stream3.flatMap((value) -> {
                    String[] split = value.split(" ");
                    return (Stream<String>) Arrays.asList(split).stream();
                })
                .forEach((value) -> System.out.println(value))
        ;

        /**
         * Lambda Using free variable .....
         */

        int s = 4;

        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers4.stream().forEach(x->System.out.println(s+x));

    }

}
