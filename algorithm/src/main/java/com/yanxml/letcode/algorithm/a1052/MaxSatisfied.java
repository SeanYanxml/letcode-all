package com.yanxml.letcode.algorithm.a1052;

/**
* 1052. 爱生气的书店老板
* https://leetcode-cn.com/problems/grumpy-bookstore-owner/
* 
* Author: sean
* Date:Feb 24, 202111:56:04 PM
*/

public class MaxSatisfied {
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int length = customers.length;
		int result = 0;
		int []tmpCustomers = new int[length];
		// 填充老板生气时候的列表.
		for(int i=0;i<length;i++) {
			if(grumpy[i]==1) {
				tmpCustomers[i] = customers[i];
			}else {
				tmpCustomers[i] = 0;
			}
		}
		// 扫描生气列表
		int maxSatifyInSad = 0;
		// 用于变化的临时变量
		int tmpMaxSatifyInSad = 0;
		
		// 初始化
		if(X<=length) {
			for(int i=0;i<X;i++) {
				tmpMaxSatifyInSad += tmpCustomers[i];
			}
			maxSatifyInSad = tmpMaxSatifyInSad;
		}
		// 推动循环 获取最大值
		for(int i=X; i<length; i++) {
			// 数字推动变化
			tmpMaxSatifyInSad = tmpMaxSatifyInSad + tmpCustomers[i] - tmpCustomers[i-X];
			if(tmpMaxSatifyInSad > maxSatifyInSad) {
				maxSatifyInSad = tmpMaxSatifyInSad;
			}
		}
		
		for(int i=0; i<length;i++) {
			if(grumpy[i]==0) {
				result += customers[i];
			}
		}
		result += maxSatifyInSad ;
		return result;
    }

}
