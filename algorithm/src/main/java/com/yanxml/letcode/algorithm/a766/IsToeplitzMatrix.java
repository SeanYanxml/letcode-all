package com.yanxml.letcode.algorithm.a766;

/**
* 766. 托普利茨矩阵
* https://leetcode-cn.com/problems/toeplitz-matrix/
* 
* 拓展1: 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
* 拓展2: 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
* Author: sean
* Date:Feb 22, 202111:54:25 PM
*/

public class IsToeplitzMatrix {
	/**
	 * 考虑如下几种情况:
	 * 1. 正方形
	 * 2. 扁长方形
	 * 3. 竖长方形
	 * */
   public boolean isToeplitzMatrix(int[][] matrix) {
	   return false;
    }	
   
   /***
   上半对角规律
   [a(0,jLength-1)]
   [a(0,jLength-2) a(1,jLength-1)]
   [a(0,jLength-3) a(1,jLength-2) a(2,jLength-1)]
   [a(0,jLength-i) a(1,jLength-i+1) ... a(i-1,jLength-1)]
   ---
   下半对角规律
   [a(0,0),a[1,1] a[2,2]]
   [a[1,0] a[2.1] a[3,2]]
   [a[i,0] a[i+1,1] a[i+2,2] ... a[jLength-1-i+1,jLength-1]]

   a[2,0] ... a[1,2]
***/
}
