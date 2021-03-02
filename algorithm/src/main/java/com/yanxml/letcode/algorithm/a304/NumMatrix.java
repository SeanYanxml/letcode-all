package com.yanxml.letcode.algorithm.a304;

/**
* 304. 二维区域和检索 - 矩阵不可变
* https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
* 303的变种.
* 
* Author: sean
* Date:Mar 2, 20219:12:48 PM
*/

class NumMatrix {
    int sums[][] = null;
    public NumMatrix(int[][] matrix) {
        if(null != matrix && matrix.length >0){
        	sums = new int[matrix.length][matrix[0].length];
        	// 行和
        	for(int i=0; i< matrix.length; i++) {
        		// 初始化
        		sums[i][0] = matrix[i][0];
        		// 计算行的和
        		for(int j=1; j<matrix[0].length;j++) {
        			sums[i][j] += sums[i][j-1] + matrix[i][j];
        		}
        	}
        	printMatrix();
        	// 列和
        	for(int j=0; j< matrix[0].length; j++) {
        		for(int i=1;i<matrix.length;i++) {
        			sums[i][j] = sums[i-1][j] + sums[i][j];
        		}
        	}
        	printMatrix();
        }
    }
    
    // 优化点 - 数组从0开始 便于边界计算
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(row1>0 && col1>0) {
    		// System.out.println(sums[row2][col2] +" "+sums[row1-1][col1-1]+" "+sums[row1-1][col2]+" "+sums[row2][col1-1]);
    		return sums[row2][col2] + sums[row1-1][col1-1] - sums[row1-1][col2] - sums[row2][col1-1];
    	}else if (row1 > 0 && col1 == 0){
    		// System.out.println(sums[row2][col2] +" "+sums[row1-1][col2]);
    		return sums[row2][col2]  - sums[row1-1][col2];
    	}else if(col1>0 && row1 == 0) {
    		// System.out.println(sums[row2][col2] +" "+ sums[row2][col1-1] );
    		return sums[row2][col2] - sums[row2][col1-1] ;
    	}else {
    		// 都等于0
    		// System.out.println(sums[row2][col2]);
    		return sums[row2][col2];
    	}
    }
    
    public void testMethod1() {
    	int [][]matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
    	NumMatrix demo = new NumMatrix(matrix);
    	System.out.println(demo.sumRegion(2, 1, 4, 3));
    	System.out.println(demo.sumRegion(1, 1, 2, 2));
    	System.out.println(demo.sumRegion(1, 2, 2, 4));
    }
    
    public void testMethod2() {
    	int [][]matrix = {{-4, -5}};
    	NumMatrix demo = new NumMatrix(matrix);
    	System.out.println(demo.sumRegion(0, 0, 0, 0));
    	System.out.println(demo.sumRegion(0, 0, 0, 1));
    	System.out.println(demo.sumRegion(0, 1, 0, 1));
    }
    
    public void printMatrix() {
		System.out.println("---------------");
    	for(int i=0;i<sums.length;i++) {
    		for(int j=0; j<sums[0].length;j++) {
    			System.out.print(sums[i][j]+" ");
    		}
    		System.out.println();
    	}
		System.out.println("---------------");
    }
    
    public static void main(String[] args) {
    	// (new NumMatrix(null)).testMethod1();
    	(new NumMatrix(null)).testMethod2();
	}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
