package com.yanxml.letcode.algorithm.a1438;

/**
 *
 * 1438. 绝对差不超过限制的最长连续子数组
 * https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * 
 * 有点意思。 测试用例有点极限。
 * 
 * Author: sean Date:Feb 21, 202111:55:47 PM
 */

public class LongestSubarray1438 {

	// 实际上是求最大值和最小值
	// 注意审题: 最大是求的长度

	// 思路1 - O(N^2)
	public static int longestSubarrayMethod1(int[] nums, int limit) {
		int lastOkLimitLength = 0;
		outerI: 
		for (int i = 0; i < nums.length; i++) {
			// 头结点 从i开始计算
			int max = nums[i], min = nums[i];
			boolean flag = false;

			int length = 0;

			outerJ: 
			for (int j = i; j < nums.length; j++) {
				// 优化点2 - 有数字变化再进行比较
				flag = false;
				// 最大值和最小值都从头开始计算
				if (nums[j] > max) {
					max = nums[j];
					flag = true;
				} else if (nums[j] < min) {
					min = nums[j];
					flag = true;
				}

				if (flag) {
					// 优化点1
					// 比较
					int limitNum = Math.abs(max - min);
					// int limitLength = j-i+1;
					if (limitNum <= limit) {
						// if(limitLength > lastOkLimitLength) {
						// }
						length++;
					} else {
						break outerJ;
					}
				} else {
					length++;
				}

				if (length > lastOkLimitLength) {
					lastOkLimitLength = length;
				}

			}

			// 结束条件2
			if (lastOkLimitLength >= ((nums.length - i + 1) - 1)) {
				break outerI;
			}
		}
		return lastOkLimitLength;
	}

	// 思路2 - O(N*logN)

	public static void testCase1() {
		int array[] = { 8, 2, 4, 7 };
		int limit = 4;
		int resultLimit = longestSubarrayMethod1(array, limit);
		System.out.println(resultLimit);
	}

	public static void testCase2() {
		int array[] = { 10, 1, 2, 4, 7, 2 };
		int limit = 5;
		int resultLimit = longestSubarrayMethod1(array, limit);
		System.out.println(resultLimit);
	}

	public static void testCase3() {
		int array[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int limit = 10;
		int resultLimit = longestSubarrayMethod1(array, limit);
		System.out.println(resultLimit);
	}

	public static void main(String[] args) {
		// testCase1();
		// testCase2();
		testCase3();
	}

}

//
// int lastOkLimitLength = 0;
// outerI:
// for(int i=0; i<nums.length; i++){
// // 头结点 从i开始计算
// int max = nums[i], min = nums[i];
// boolean flag = false;
//
// int length = 0;
//
// outerJ:
// for(int j=i;j<nums.length;j++){
// // 优化点2 - 有数字变化再进行比较
// flag = false;
// // 最大值和最小值都从头开始计算
// if(nums[j]>max){max = nums[j];
// flag=true;
// }
// else if(nums[j]<min){min=nums[j];
// flag = true;
// }
//
// if(flag ) {
// // 优化点1
// // 比较
// int limitNum = Math.abs(max-min);
// // int limitLength = j-i+1;
// if(limitNum <= limit) {
// // if(limitLength > lastOkLimitLength) {
// // }
// length++;
// } else {
// break outerJ;
// }
// }else {
// length++;
// }
//
//
// if(length > lastOkLimitLength) {
// lastOkLimitLength = length;
// }
//
// }
//
// // 结束条件2
// if(lastOkLimitLength >= ((nums.length-i+1)-1)) {
// break outerI;
// }
// }
// return lastOkLimitLength;
// }
