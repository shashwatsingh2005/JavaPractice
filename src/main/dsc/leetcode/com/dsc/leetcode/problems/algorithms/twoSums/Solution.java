package com.dsc.leetcode.problems.algorithms.twoSums;
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
class Solution {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 4 };
		System.out.println(twoSum(arr, 6));
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] retVal = new int[2];
		for (int i = 0; i <= nums.length - 1; i++) {
			for (int j = 0; j <= nums.length - 1; j++) {
				if (i != j) {
					if (nums[i] + nums[j] == target) {
						retVal[0] = i;
						retVal[1] = j;
						return retVal;
					}
				}
			}
		}
		return retVal;
	}
}