package com.dsc.leetcode.arrays.median;

/**
 * @author shashwat<br>
 * 
 *         Given two sorted arrays nums1 and nums2 of size m and n respectively,
 *         return the median of the two sorted arrays.
 * 
 *         The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged
 *         array = [1,2,3] and median is 2. Example 2:
 * 
 *         Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation:
 *         merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 *         Constraints:
 * 
 *         nums1.length == m nums2.length == n 0 <= m <= 1000 0 <= n <= 1000 1
 *         <= m + n <= 2000 -106 <= nums1[i], nums2[i] <= 106
 */
public class FindArrayMedian {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,5,6};
		int[] nums2 = {4};
		double median = findMedianSortedArrays(nums1,nums2);
		System.out.println("Median  ::  "+median);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0.0d;
		// make sure that we apply binary search algo on the smaller array
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		// Check to make sure that if any array has 0 elements
		if(nums1.length == 0) {
			nums1 = new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE};
		}
		
		if(nums2.length == 0) {
			nums2 = new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE};
		}

		int m = nums1.length;
		int n = nums2.length;
		int halfLenth = (m + n + 1) / 2;
		// Since we are performing search smaller array.
		int low = 0;
		int high = m;

		// Starting the logic...
		while (low <= high) {
			int i = (low + high) >> 1;
			int j = halfLenth - i;

			int l1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
			int r1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

			int l2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
			int r2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

			if (l1 <= r2 && l2 <= r1) {
				if ((m + n) % 2 == 0) {
					return median = ((Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
				} else {
					return median = Math.max(l1, l2);
				}
			} else {
				if (l1 > r2) {
					high = i - 1;
				} else {
					low = i + 1;
				}
			}

		}
		return median;
	}

}
