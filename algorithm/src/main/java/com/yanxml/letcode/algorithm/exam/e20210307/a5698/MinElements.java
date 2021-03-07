package com.yanxml.letcode.algorithm.exam.e20210307.a5698;

/**
 *
 * Author: sean Date:Mar 7, 202110:51:34 AM
 */

public class MinElements {
	public int minElements(int[] nums, int limit, int goal) {
		int resultNum = 0;
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		long extNum = Math.abs(goal - sum);

		resultNum = (int) (extNum / limit);
		if (extNum % limit > 0) {
			resultNum++;
		}

		return resultNum;
	}
	
	// sum和越界了
	public void testCase1() {
		int nums[] = {1};
	}

		
}
