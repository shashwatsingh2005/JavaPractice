package com.java.features.eight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Shashwat Singh Here we will see all Non Terminal Operations.
 */
public class StreamNonTerminalOps {
	/**
	 * Initial Stream for Demo.
	 */
	private static List<Integer> intList = null;

	/**
	 * Main Method Depicting all other Non Terminal Methods Demo. Here we will be
	 * calling all Methods One by one.
	 */
	public static void main(String[] args) {
		// peek() ... Visits all elements once and returns a new Stream
		streamPeek();
		// filter() ... demo filter the elements
		streamFilter();
		// sorted() :: sorting the elements of the stream
		streamSorted();
	}

	/**
	 * peek() method illustration
	 */
	static void streamPeek() {
		intList = Arrays.asList(23, 21, 45, 11, 1, 6, 8, 6, 6, 11, 34, 56);
		// intList.add(1000); :: Arrays.asList() returns a fixed-size list backed by an
		// array, so .add() throws an exception.
		Stream<Integer> stream = intList.stream();
		// Here we wont see any print statement executed as streams are lazy.
		Stream<Integer> nextStream = stream.peek(i -> System.out.println("Creation Peek :: " + i));
		if (nextStream != null) {
			System.out.println("Are both Streams Similar  :: " + (stream.equals(nextStream)));
			System.out.println("Since we got new stream also Lets Peek this one too.");
			/*
			 * An implementation may choose to not execute the stream pipeline (either
			 * sequentially or in parallel) if it is capable of computing the count directly
			 * from the stream source. In such cases no source elements will be traversed
			 * and no intermediate operations will be evaluated.
			 */
			nextStream.peek(i -> System.out.println("Second Peek :: " + i)).count();
		}
	}

	/**
	 * filter() method illustration with use of predicate map() method also
	 * demonstrated here.
	 */
	static void streamFilter() {
		intList = Arrays.asList(23, 21, 45, 11, 1, 6, 8, 6, 6, 11, 34, 56);
		Stream<Integer> stream = intList.stream();
		/*
		 * Will create a new Stream with some filtered members .. Two operations filter
		 * and map are not executed immediately. They will be executed upon meeting any
		 * terminal ops
		 */
		Stream<Integer> nextStream = stream.filter(p -> p > 32).map(i -> i * 2);
		/**
		 * Now all the operations will be executed both Filter and map
		 */
		nextStream.forEach(System.out::println);
	}

	/**
	 * sorted() :: Returns a stream of elements from original stream just that that
	 * now elements are in sorted order.
	 */
	static void streamSorted() {
		intList = Arrays.asList(23, 21, 45, 11, 1, 6, 8, 6, 6, 11, 34, 56);
		Stream<Integer> stream = intList.stream();
		/**
		 * Returns a stream of all elements from original Stream Just in sorted order.
		 */
		Stream<Integer> nextStream = stream.sorted().sorted((i1, i2) -> i2 - i1);
		/**
		 * Now all the operations will be executed both Filter and map
		 */
		nextStream.forEach(System.out::println);
	}

}
