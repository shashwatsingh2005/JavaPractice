package com.java.features.eight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Examples of java streams using examples of Emails
 * 
 * @author shashwat Singh
 */
public class EmailStreams {
	public static void main(String[] args) {
		List<String> emails = Arrays.asList("alice@gmail.com", "bob@yahoo.com", "charlie@outlook.com",
				"david@icloud.com", "emma@protonmail.com", "frank@zoho.com", "grace@rediffmail.com", "henry@mail.com",
				"isabel@gmx.com", "jack@aol.com","shashwat@aol.com");
		emails.stream().map(s -> s.substring(s.indexOf("@") + 1)).forEach(System.out::println);

		Map<String, Long> countByDomain = emails.stream()
				.collect(Collectors.groupingBy(s->s.substring(s.indexOf("@") + 1), Collectors.counting()));
		
		System.out.println(countByDomain);
	}
}
