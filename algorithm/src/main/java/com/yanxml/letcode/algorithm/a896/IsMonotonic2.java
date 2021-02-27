package com.yanxml.letcode.algorithm.a896;

/**
* 优化版本。 不需要判断操作数目。 直接进行判断。
* Author: sean
* Date:Feb 28, 202112:08:15 AM
*/

public class IsMonotonic2 {
	 // 方法2 - 边扫描 边判断
	 // 判断是增 还是减少
    public static boolean isMonotonic(int[] A) {
    	boolean flag = true;
    	// 只有一个数字一定成功
    	if(null != A && A.length >1) {
    		int index = 0;
    		// 这里认为操作数目 -1 表示相等 0 表示递增 1 表示递减
    		int operateFlag = -1;
        	// 直接判断 单调的情况
    		while(index+1 < A.length) {
    			if(A[index] < A[index+1]) {
					// 单调增 0
    				
    				// 优化点 - 此次还可以优化一下 因为==-1判断次数稍微有点少
    				if(operateFlag == -1) {
						// 初始状态 单调状态转变
						operateFlag = 0;
					} else if(operateFlag == 1) {
						// 递减 转变递增  - 出现混合的情况
						flag = false;
						break;
					}
					
				}else if(A[index] > A[index+1]){
					// 先和之前的状态值进行判断
					// 单调减 1
    				if(operateFlag == -1) {
						// 初始状态 单调状态转变
						operateFlag = 1;
					} else if(operateFlag == 0) {
						// 递增 转变 递减 - 出现混合的情况
						flag = false;
						break;
					}
					operateFlag = 1;
				}
//				else {
//					// 相等 - 没有操作
//					index++;
//				}
				index++;
    		}
    	}
    	return flag;
    	// 废弃思考点 - 哨兵值. 用来比对
    	// 本题不用哨兵值进行比对
    }
    
    
  

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
