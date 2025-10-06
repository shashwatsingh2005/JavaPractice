package com.dsc.leetcode.problems.algorithms.twoSums;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.<br>
 * <br>
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.<br>
 * You can return the answer in any order.<br>
 * <br>
 * Example 1:<br>
 * Input: nums = [2,7,11,15], target = 9<br>
 * Output: [0,1]<br>
 * <br>
 * Example 2:<br>
 * Input: nums = [3,2,4], target = 6<br>
 * Output: [1,2]<br>
 * <br>
 * Example 3:<br>
 * Input: nums = [3,3], target = 6<br>
 * Output: [0,1]<br>
 * <br>
 * Constraints:<br>
 * 2 <= nums.length <= 10^4<br>
 * -10^9 <= nums[i] <= 10^9<br>
 * -10^9 <= target <= 10^9<br>
 * Only one valid answer exists.<br>
 * <br>
 * 
 * @author Shashwat
 * 
 *         <br>
 *         <br>
 */
public class Optimised {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 4 };
		System.out.println(twoSum(arr, 6));
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] retVal = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(0);
		for (int i = 0; i <= nums.length - 1; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		return retVal;
	}

}
