package com.java.features.eight.streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	}
}
