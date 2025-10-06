package com.java.features.eight.streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * @author Shashwat Singh Here we will see all Terminal Operations. 1.collect()
 *         2.count() 3.forEach() 4.max() 5.min() 6.reduce() 7.toArray()
 */
public class StreamTerminalOps {
	/**
	 * Initial Stream for Demo.
	 */
	private static List<Integer> intList = null;

	/**
	 * Initial String Stream for Demo.
	 */
	private static List<String> strList = null;

	/**
	 * Main Method Depicting all other Non Terminal Methods Demo. Here we will be
	 * calling all Methods One by one.
	 */
	public static void main(String[] args) {
		// collect() method demo call
		streamCollect();
		// anyMatch method demo call
		streamAnyMatch();
		// Demo for Lazy nature of streams
		streamLazyDemo();
	}

	/**
	 * 1. collect() :: Method demo and details.
	 */
	static void streamCollect() {
		intList = Arrays.asList(23, 21, 45, 11, 1, 6, 8, 6, 6, 11, 34, 56);
		Stream<Integer> stream = intList.stream();
		/**
		 * Will be collecting all elements into sets... Since sets dont support
		 * duplicates the duplicate values will be removed.
		 */
		Set<Integer> set = stream.map(i -> i).collect(Collectors.toSet());
		System.out.println("Size of the set :: " + set.size());

		strList = Arrays.asList("hello", "shashwat", "how", "are", "you", "Is", "Everything", "going", "well");
		List<String> finList = strList.stream()
				.collect(Collectors.filtering(p -> p.length() >= 8, Collectors.toList()));
		Iterator<String> itr = finList.iterator();
		while (itr.hasNext()) {
			// filtered and then collected list ...
			System.out.println("Filtered Elements and then Collected Elements :: " + itr.next());
		}
		// getting Map out of the Stream
		Stream<Integer> intStr2 = intList.stream();
		Map<Object, Long> intMap = intStr2.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		Iterator<Object> itr2 = intMap.keySet().iterator();
		while (itr2.hasNext()) {
			Object key = itr2.next();
			System.out.println("Frequency of Element -- " + key + " is -- " + intMap.get(key));
		}
		// Demonstrating Partitioning ...
		Stream<Integer> stream2 = intList.stream();
		Map<Boolean, List<Integer>> partMap = stream2.collect(Collectors.partitioningBy(i -> i > 30));
		System.out.println("Printing Map :: " + partMap);
		// mapping before collecting
		Map<Integer, List<Character>> mapped = strList.stream().collect(
				Collectors.groupingBy(String::length, Collectors.mapping(s -> s.charAt(0), Collectors.toList())));
		System.out.println("Mapped Lists :: " + mapped);
		// general Partioning ...
		Map<Object, List<String>> vectList = strList.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println("Mapped Data For Strings :: " + vectList);
		//Reducing Using Collectors...
		Stream<String> vectList1 = strList.stream();
 		Optional<String> vectList2 = vectList1.collect(Collectors.reducing((s1,s2)->s1+s2));
		System.out.println("Demonstration of Reducing :: " + vectList2);
		Stream<String> vectList3 = strList.stream();
		double average = vectList3.collect(Collectors.averagingDouble(s->s.length()));
		System.out.println("Demonstrating collect ---- Average : "+average);
		Stream<String> vectList4 = strList.stream();
		String collectExample = vectList4.collect(Collectors.joining("-"));
		System.out.println("Demonstrating collect ---- joining(String arg) : "+collectExample);
		Stream<String> vectList5 = strList.stream();
		Map<String,Integer> mapCollect = vectList5.collect(Collectors.toMap(s->s, s->s.length()));
		//Here in to map first arg is the key and second arg is the value.
		System.out.println("Demonstrating collect ---- toMap(String arg,Integer arg2) :"+mapCollect);
		Stream<String> vectList6 = strList.stream();
		Map<Integer,String> mapCollect1 = vectList6.collect(Collectors.toMap(s->s.length(), s->s,(s1,s2)->s1+" :: "+s2));
		//Here in to map first arg is the key and second arg is the value.And we provide BiFunction to merge two objects with same value
		System.out.println("Demonstrating collect ---- toMap(Integr arg,String arg2,BiFunction mergeFunction) :"+mapCollect1);
		List<String >strList1 = Arrays.asList("hello", "shashwat", "how", "are", "you", "Is", "Everything", "going", "well", "Is");
		Stream<String> vectList7 = strList1.stream();
		Map<String,Integer> mapCollect2 = vectList7.collect(Collectors.toMap(s->s, s->s.length(), (s1,s2)->s1+s2, ()->new TreeMap<String, Integer>()));
		//Here in to map first arg is the key and second arg is the value.And we provide BiFunction to merge two objects with same value
		//And fourth Argument is the type of map we need.
		System.out.println("Demonstrating collect ---- toMap(Integr arg,String arg2,BiFunction mergeFunction,Supplier s) :"+mapCollect2);
		
		System.out.println("===========================================JAVA EQUALS=====================================================");
		String a = "java";
		String b = "java";
		String c = new String ("java");
		
		System.out.println(a==c);
		
		

	}
	
		/**
	 * 2.anyMatch() : Demo
	 */
	static void streamAnyMatch() {
		intList = Arrays.asList(23, 21, 45, 11, 1, 6, 8, 6, 6, 11, 34, 56);
		Stream<Integer> stream = intList.stream();
		boolean isAnyMatch = stream.map(i -> "Mapped i : " + i).anyMatch(i -> (i.equals("Mapped i : 21")));
		System.out.println("Is there any Match : " + isAnyMatch);
	}

	/**
	 * Demo for lazy nature of stream
	 */
	static void streamLazyDemo() {
		strList = Arrays.asList("Shashwat", "Divyanshu", "Smit", "Ankita", "Rohit", "January", "May");

		Stream<String> stream = strList.stream();

		stream.peek(s -> System.out.println("peek () : " + s)).filter(s -> {
			System.out.println("filter () " + s);
			return s.length() >= 8;
		}).filter(s -> {
			System.out.println("filter ()");
			return s.startsWith("S");
		}).limit(1).forEach(System.out::println); // limit(long) : limits the times when a terminal operation is done
	}
}
