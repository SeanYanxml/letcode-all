package com.yanxml.letcode.algorithm.a354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题 
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 
 * 说实话. 没思路. 看了题解.
 * Author: sean 
 * Date:Mar 4, 202111:18:48 PM
 */

public class MaxEnvelopes {
	
	//  1 2 i=0,j=1,2
	//  1 3 i=1 j=1,2
	//  1 4 i=3 j=1,2
	//  1 5 i=4 j=1,2
	// 竖状的数组 envelopes[k][2] 列为k 长为2
	public int maxEnvelopes(int[][] envelopes) {
		int result = 1;
		// 先排序
		Arrays.sort(envelopes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
                // 注意点1 - 注意此处需要生序排序 否则影响后续编写
				if(o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}else {
					// 第一位相等 比较第二位数字
                    // 注意点2 - 注意此处倒叙排序?
					// 长度一样时 大的信封放在前面? 为什么?
					return o2[1] - o1[1];
				}
			}
		});
		// 随后LIT
		int price[] = new int[envelopes.length];
		for(int i=0;i<price.length;i++) {
			price[i] = 1;
		}
		
		for(int i=0;i<envelopes.length;i++) {
			for(int j=0;j<i;j++) {
				if(envelopes[i][1]>envelopes[j][1]) {
					price[i] = (price[i]>(price[j]+1)) ? price[i] : (price[j]+1);
				}
			}
			result = (price[i]>result) ?price[i]:result;
		}
		return result;
    }
}
