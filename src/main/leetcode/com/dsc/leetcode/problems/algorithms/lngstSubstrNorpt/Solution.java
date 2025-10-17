package com.dsc.leetcode.problems.algorithms.lngstSubstrNorpt;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, find the length of the longest substring without duplicate
 * characters. <br>
 * <br>
 * <b>Example 1:</b><br>
 * Input: s = "abcabcbb"<br>
 * Output: 3<br>
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and
 * "cab" are also correct answers. <br>
 * <br>
 * <b>Example 2:</b><br>
 * Input: s = "bbbbb"<br>
 * Output: 1<br>
 * Explanation: The answer is "b", with the length of 1. <br>
 * <br>
 * <b>Example 3:</b><br>
 * Input: s = "pwwkew"<br>
 * Output: 3<br>
 * Explanation: The answer is "wke", with the length of 3.<br>
 * Notice that the answer must be a substring — "pwke" is a subsequence, not a
 * substring. <br>
 * <br>
 * <b>Constraints:</b><br>
 * 0 <= s.length <= 5 * 10⁴<br>
 * s consists of English letters, digits, symbols, and spaces.
 */

public class Solution {
	public static void main(String[] args) {
		String s = "au";
		int len = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int j = i;
			while(j <= s.length()) {
				String subStr = s.substring(i, j);
				System.out.println(subStr +" ------- "+containsDuplicateCharacters(subStr));
				if(!containsDuplicateCharacters(subStr)) {
					if(len < subStr.length()) {
						len = subStr.length();
					}
				}
				j++;
			}
		}
	}
	
	public static boolean containsDuplicateCharacters(String s) {
		List<Character> listOfChars = new ArrayList<Character>();
		for(int i = 0; i < s.length();i++) {
			Character c = s.charAt(i);
			if(listOfChars.contains(c) && listOfChars.size() == 0) {
				listOfChars.add(c);
			}else if(listOfChars.contains(c) && listOfChars.size() > 0) {
				return true;
			}else {
				listOfChars.add(c);
			}
		}
		return false;
	}
}
