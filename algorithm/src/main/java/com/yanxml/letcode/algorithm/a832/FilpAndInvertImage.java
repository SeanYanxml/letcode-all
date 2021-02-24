package com.yanxml.letcode.algorithm.a832;

/**
* 832. 翻转图像
* https://leetcode-cn.com/problems/flipping-an-image/
* 
* Author: sean
* Date:Feb 24, 202111:59:26 PM
*/

public class FilpAndInvertImage {
	
	// 不使用临时空间
	// 注意第i层第j个数字是 A[I][J]不是A[J][I]
	// A[0][1] A[0][2] A[0][3]是一行的 . A[1][0] A[2][0] A[3][0]是一列.
    public int[][] flipAndInvertImage(int[][] A) {
    	if(null != A && A.length > 0) {
        	int jLength = A.length;
        	int iLength = A[0].length;
        	for(int j=0; j < jLength; j++) {
        		// 倒序 - 并不是首尾互换
        		int indexPre = 0;
        		int indexBack = iLength-1;
        		while(indexPre <= indexBack) {
        			if(indexPre == indexBack) {
        				// SWAP
            			A[j][indexPre] = negation(A[j][indexBack]);
        			}else {
        				// SWAP
            			int tmp = A[j][indexPre];
            			A[j][indexPre] = negation(A[j][indexBack]);
            			A[j][indexBack] = negation(tmp);
        			}
        			indexPre ++;
        			indexBack --;
        		}
        	}
    	}
    	return A;
    }
    
    // 如果题目要求不能改变原数组条件 那么新创建一个临时数组用于存储结果即可.
    
    public static int negation(int num) {
    	if(num == 0) {
    		return 1;
    	}else {
    		return 0;
    	}
    }

}
