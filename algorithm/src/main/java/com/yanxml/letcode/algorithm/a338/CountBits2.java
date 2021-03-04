package com.yanxml.letcode.algorithm.a338;

/**
* 方法2 O(N)
* 不断迭代前者.
* Author: sean
* Date:Mar 3, 202112:17:32 AM
*/

public class CountBits2 {
	public int[] countBits(int num) {
        int[] result = new int[num+1];
        if(num >= 1) {
        	result[1] = 1;
        }
        for(int i=1;i<=num/2;i++) {
        	result[2*i] = result[i];
        	if(2*i+1<=num) {
            	result[2*i+1] = result[i]+1;
        	}
        }
        return result;
    }

}
