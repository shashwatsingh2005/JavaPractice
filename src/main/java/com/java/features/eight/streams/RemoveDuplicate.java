package com.java.features.eight.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class demonstrating duplicate removal using streams.
 * 
 * @author shashwat Singh
 */
public class RemoveDuplicate {
	public static void main(String[] args) {
		// Initial stream
		Stream<Integer> stream = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
		Stream<Integer> stream1 = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
		List<Integer> list 
        = Arrays.asList(5, 13, 4, 
                        21, 13, 27, 
                        2, 59, 59, 34); 

		// Print the found duplicate elements
		System.out.println(findDuplicateInStream(stream));
		
		System.out.println(findDuplicateInStream1(stream1));
		
		System.out.println(findDuplicateInStream(list));
	}

	public static <T> Set<T> findDuplicateInStream(Stream<T> stream) {
		Set<Integer> duplicates = new HashSet<Integer>();
		return stream.filter(n-> !duplicates.add((Integer) n)).collect(Collectors.toSet());
	}
	
	public static <T> Set<T> findDuplicateInStream1(Stream<T> stream) 
    { 
  
        // Return the set of duplicate elements 
        return stream 
  
            // Group the elements along 
            // with their frequency in a map 
            .collect( 
                Collectors.groupingBy( 
                    Function.identity(), 
                    Collectors.counting())) 
  
            // Convert this map into a stream 
            .entrySet() 
            .stream() 
  
            // Check if frequency > 1 
            // for duplicate elements 
            .filter(m -> m.getValue() > 1) 
  
            // Find such elements 
            .map(Map.Entry::getKey) 
  
            // And Collect them in a Set 
            .collect(Collectors.toSet()); 
    }
	
	public static <T> Set<T> 
    findDuplicateInStream(List<T> list) 
    { 
        // Return the set of duplicate elements 
        return
  
            // Get the stream from the list 
            list.stream() 
  
                // Count the frequency of each element 
                // and filter the elements 
                // with frequency > 1 
                .filter(i -> Collections.frequency(list, i) > 1) 
  
                // And Collect them in a Set 
                .collect(Collectors.toSet()); 
    } 
}
