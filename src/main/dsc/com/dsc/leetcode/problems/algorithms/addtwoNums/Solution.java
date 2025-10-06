package com.dsc.leetcode.problems.algorithms.addtwoNums;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers.<br>
 * The digits are stored in reverse order, and each of their nodes contains a
 * single digit.<br>
 * Add the two numbers and return the sum as a linked list.<br>
 * <br>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.<br>
 * <br>
 * Example 1:<br>
 * Input: l1 = [2,4,3], l2 = [5,6,4]<br>
 * Output: [7,0,8]<br>
 * Explanation: 342 + 465 = 807.<br>
 * <br>
 * Example 2:<br>
 * Input: l1 = [0], l2 = [0]<br>
 * Output: [0]<br>
 * <br>
 * Example 3:<br>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]<br>
 * Output: [8,9,9,9,0,0,0,1]<br>
 * <br>
 * Constraints:<br>
 * - The number of nodes in each linked list is in the range [1, 100].<br>
 * - 0 <= Node.val <= 9<br>
 * - It is guaranteed that the list represents a number that does not have
 * leading zeros.<br>
 */
public class Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		long i1 = 0;
		long i2 = 0;
		int j = 0;
		do {
			i1 += (l1.val) * Math.pow(10, j);
			l1 = l1.next;
			j++;
		} while (l1 != null);
		j = 0;
		do {
			i2 += (l2.val) * Math.pow(10, j);
			l2 = l2.next;
			j++;
		} while (l2 != null);

		System.out.println("i1 : " + i1 + "  -----  i2 : " + i2);
		long sum = i1 + i2;
		
		j = (""+sum).length() - 1;
		ListNode retVal = null;
		ListNode pointer = null;
		do {
			if(null == retVal ) {
				retVal = new ListNode();
			retVal.val = Integer.parseInt(""+(""+sum).charAt(j));
			System.out.println("---------------------"+retVal.val);
			pointer = retVal;
			j--;
			}else {
				pointer.next = new ListNode(Integer.parseInt(""+(""+sum).charAt(j)));
				pointer = pointer.next;
				j--;
			}
		}while(j >= 0);
		return retVal;
	}

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(1);
		l3.next = new ListNode(9);
		l3.next.next = new ListNode(9);
		l3.next.next.next = new ListNode(9);
		l3.next.next.next.next = new ListNode(9);
		l3.next.next.next.next.next = new ListNode(9);
		l3.next.next.next.next.next.next = new ListNode(9);
		l3.next.next.next.next.next.next.next = new ListNode(9);
		l3.next.next.next.next.next.next.next.next = new ListNode(9);
		l3.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		ListNode l4 = new ListNode(9);

		ListNode ret = addTwoNumbers(l4, l3);
		System.out.println("Hello");
	}
}
