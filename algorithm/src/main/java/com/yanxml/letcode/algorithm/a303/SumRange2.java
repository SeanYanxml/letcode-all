package com.yanxml.letcode.algorithm.a303;

/**
 * 看了题解. 动态规划版本. O(1)复杂度
 * Author: sean Date:Mar 1, 202111:48:12 PM
 */

public class SumRange2 {
	public int sums[] = null;

	public SumRange2(int[] nums) {
	   sums[0] = nums[0];
	   for(int i = 1; i <= nums.length; i++) {
		   sums[i] = sums[i-1] + nums[i];
	   }
	}

	public int sumRange(int i, int j) {
		return sums[j]-sums[i];
	}
}
