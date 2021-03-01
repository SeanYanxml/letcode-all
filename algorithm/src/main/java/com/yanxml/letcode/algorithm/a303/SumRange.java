package com.yanxml.letcode.algorithm.a303;

/**
* 303. 区域和检索 - 数组不可变
* https://leetcode-cn.com/problems/range-sum-query-immutable/
* 
* Author: sean
* Date:Mar 1, 202111:47:26 PM
*/

public class SumRange {
    public int nums[] = null;
    public SumRange(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0; 
        if(i<=j){
            for(int index = i; index<=j; index++){
                sum += nums[index];
            }
        }
        return sum;
    }
}
