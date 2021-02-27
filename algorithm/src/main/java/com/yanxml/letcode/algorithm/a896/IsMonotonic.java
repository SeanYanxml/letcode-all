package com.yanxml.letcode.algorithm.a896;

/**
* 896. 单调数列
* https://leetcode-cn.com/problems/monotonic-array/
* 
* Author: sean
* Date:Feb 28, 202112:08:15 AM
*/

public class IsMonotonic {
	 // 判断是增 还是减少
    public static boolean isMonotonic(int[] A) {
    	boolean flag = true;
    	// 只有一个数字一定成功
    	if(null != A && A.length >1) {
    		int index = 0;
    		int operateFlag = -1;
        	// 先判断 单调增的情况
    		// 注意点 注意数字会相等的情况。
    		while(index+1 < A.length) {
    			if(A[index] < A[index+1]) {
					// 单调增
					operateFlag = 0;
					break;
				}else if(A[index] > A[index+1]){
					// 单调减
					operateFlag = 1;
					break;
				}else {
					// 相等 - 没有操作
					index++;
				}
    		}
    		if(operateFlag == -1) {
    			return true;
    		}
    		// 获取了单调增 还是单调减少 进行判断
    		for(int i=0;i < A.length-1;i++) {
    			// 如果出现不满足单调的情况
    			if(!operateJudge(A[i],A[i+1],operateFlag)) {
    				flag = false;
    				break;
    			}
    		}
    	}
    	return flag;
    	// 废弃思考点 - 哨兵值. 用来比对
    	// 本题不用哨兵值进行比对
    }
    
    // flag = 0 单调增
    // flag = 1 单调减
    public static boolean operateJudge(int front, int back,int flag) {
    	if(flag==0 && back >= front) {
    		return true;
    	}else if(flag ==1 && back <= front) {
    		return true;
    	}
    	return false;
    }
    
    // 方法2 - 边扫描 边判断

    // true
    public static void testCase1() {
    	int array[] = {1,2,2,3};
    	System.out.println(isMonotonic(array));
    }
    
    //true
    public static void testCase2() {
    	int array[] = {6,5,4,4};
    	System.out.println(isMonotonic(array));
    }
    
    // false
    public static void testCase3() {
    	int array[] = {1,3,2};
    	System.out.println(isMonotonic(array));
    }
    
    // true
    public static void testCase4() {
    	int array[] = {1,2,4,5};
    	System.out.println(isMonotonic(array));
    }
    
    // true
    public static void testCase5() {
    	int array[] = {1,1,1};
    	System.out.println(isMonotonic(array));
    }
    
    public static void main(String[] args) {
    	testCase1();
    	testCase2();
    	testCase3();
    	testCase4();
    	testCase5();
	}
}
