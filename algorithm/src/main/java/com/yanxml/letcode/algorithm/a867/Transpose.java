package com.yanxml.letcode.algorithm.a867;

/**
 * 867. 转置矩阵
 * 
 * 1. 注意非正方形时候. 出现的行转列的情况. 2. 注意swap操作思路. 不要重复操作2遍. 操作2遍等于无用功的情况.
 * 
 * https://leetcode-cn.com/problems/transpose-matrix/
 * 
 * @date: 2021年2月25日 上午9:42:48
 *
 * @author: xu.yan2
 * @since: JDK 1.8
 */

public class Transpose {
	public int[][] transpose(int[][] matrix) {
		int resultMatrix[][] = new int[matrix[0].length][matrix.length];
		if (null != matrix && matrix.length > 0) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					resultMatrix[j][i] = matrix[i][j];
				}
			}
		}
		return resultMatrix;
	}

	// 注意临时数组不要使用swap操作. 否则会导致转换2次无用功.
	public static void swap(int matrix[][], int i, int j) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = tmp;
	}

}
