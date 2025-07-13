package com.java.features.eight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author shashwat singh various Illustrations from the Learning videos for
 *         Streams.
 */
public class StreamUdemy {
	private static List<Integer> temps = Arrays.asList(100, 25, 45, 87, 43, 78, 95, 103);

	public static void main(String[] args) {
		// demo for terminal and intermediate Operation
		intermediateAndTerminalDemo();
	}

	static void intermediateAndTerminalDemo() {
		Stream<Integer> stream = temps.stream();
		long count = stream.peek(i -> System.out.println(i)).filter(temp -> temp >= 100).peek(i -> System.out.println(i)).count();
		System.out.println("Count After 3 Intermediate and 1 Terminal Operation :: " + count);
	}

}
