package com.yanxml.letcode.algorithm.a303;

/**
 * 看了题解. 动态规划版本. O(1)复杂度
 * Author: sean Date:Mar 1, 202111:48:12 PM
 */

public class SumRange2 {
	 // 动态规划
		public int sums[] = null;

	    public SumRange2(int[] nums) {
	       sums = new int[nums.length];
	       if(nums.length >0){
	            sums[0] = nums[0];
		        for(int i = 1; i < nums.length; i++) {
			        sums[i] = sums[i-1] + nums[i];
		        }
	       }	  
	    }
	    
	    // 注意是计算i-j 包含nums[i] nums[j]
	    // sums[j]-sums[i] 会导致缺少nums[i] 所以一般计算 sums[j] - sums[i-1]
	    // 为此又要考虑i-1为0的情况.
	    // -2 0 1 -4 -2 -3
	    public int sumRange(int i, int j) {
	        if(i==0){
	            return sums[j];
	        }else{
	            return sums[j] - sums[i-1];
	        }
	    }
}
