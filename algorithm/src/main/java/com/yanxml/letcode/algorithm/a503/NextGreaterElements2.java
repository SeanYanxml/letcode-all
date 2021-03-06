package com.yanxml.letcode.algorithm.a503;


/**
* 503. 下一个更大元素 II
* https://leetcode-cn.com/problems/next-greater-element-ii/
* 
* Author: sean
* Date:Mar 6, 202110:07:23 PM
*/

public class NextGreaterElements2 {
	// 根据题目意思进行编写 无优化方法
	/**
	 * 方法2
	 * 使用动态规划的方法进行优化.
	 * O(N*N) 感觉会超时
	 * */
	public int[] nextGreaterElementsSimpleMethod1(int[] nums) {
		// 返回值集合声明
		int result [] = new int[nums.length];
		// Arrays.fill(result, -1);
		for(int i=0;i<nums.length;i++) {
			boolean flag = false;
			// 向后搜索
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j] > nums[i]) {
					// 找到了
					result[i] = nums[j];
					flag = true;
					break;
				}
			}
			// 因为是循环数组 没找到需要从0下标开始搜索
			// if(result[i] == -1) {
			if(!flag) {
				for(int circleI = 0; circleI < i; circleI++) {
					if(nums[circleI] > nums[i]) {
						result[i] = nums[circleI];
						flag = true;
						break;
					}
				}
				// 最后还是没找到
				if(!flag) {
					result[i] = -1;
				}
			}
			
		}
		return result;
    }
	
	/** testCase1
	 * [1,2,1]
	 * error [2,0,0]
	 * correct [2,-1,2]
	 * */
	public void testCase1() {
		int[] nums = {1,2,1};
		int result[] = nextGreaterElementsSimpleMethod1(nums);
	}
	/**
	 * testCase2 需要考虑负数的情况.
	 * [1,8,-1,-100,-1,222,1111111,-111111]
	 * error [8,222,222,1,222,1111111,-1,1]
	 * correct [8,222,222,-1,222,1111111,-1,1]
	 * */
	
	public static void main(String[] args) {
		NextGreaterElements2 demo = new NextGreaterElements2();
		demo.testCase1();
	}
}
