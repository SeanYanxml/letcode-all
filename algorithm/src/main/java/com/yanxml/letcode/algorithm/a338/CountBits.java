package com.yanxml.letcode.algorithm.a338;

/**
* 338. 比特位计数
* * 简单位运算
* https://leetcode-cn.com/problems/counting-bits/
* * Author: sean
* Date:Mar 3, 202112:09:56 AM
*/

public class CountBits {
	 static int ONE = 1;
	 public int[] countBits(int num) {
	        int[] result = new int[num+1];
	        for(int i=0; i< (num+1);i++){
	            int count = 0;
	            int tmp = ONE;
	            while(tmp<=i){
	               if((i  & tmp) > 0){
	                   count++;
	               }
	               tmp = tmp << 1; 
	            }
	            result[i] = count;
	        }
	        return result;
	    }
	 public static void testMethod1() {
		 new CountBits().countBits(2);
	 }
	 
	 public static void main(String []args) {
		 testMethod1();
	 }
}
