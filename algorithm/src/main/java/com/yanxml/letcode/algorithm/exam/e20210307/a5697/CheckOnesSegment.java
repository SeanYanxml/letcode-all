package com.yanxml.letcode.algorithm.exam.e20210307.a5697;

/**
*
* Author: sean
* Date:Mar 7, 202110:34:45 AM
*/

public class CheckOnesSegment {
	public boolean checkOnesSegment(String s) {
        boolean flag = false;
        if(null != s && s.length() >0){
        	// flag = true;
        	// 前一个字母 - 判断是否存在1
            boolean hasOneFlag = false;
            // 判断1 是否还跟在后面
            int i=0;
            for(i=s.length()-1; i>=0; i--) {
            	// 首个1
            	if(!hasOneFlag && s.charAt(i)=='1') {
            		hasOneFlag = true;
            		flag = true;
            	}else if(hasOneFlag && s.charAt(i)=='0') {
            		break;
            	}	
            }
            // 随后对剩下的数字进行扫描. 判断是否存在1. 存在1就是有间隔.
            for(int j=i; j>=0; j--) {
            	if(hasOneFlag && s.charAt(j)=='1') {
            		flag = false;
            		break;
            	}
            }
        }
        return flag;
    }
	
	public void testCase1() {
		String testStr = "1001";
		System.out.println(checkOnesSegment(testStr));
	}
	
	public void testCase2() {
		String testStr = "110";
		System.out.println(checkOnesSegment(testStr));
	}
	
	public void testCase3() {
		String testStr = "011111";
		System.out.println(checkOnesSegment(testStr));
	}
	
	public static void main(String[] args) {
		CheckOnesSegment instance = new CheckOnesSegment();
		instance.testCase1();
		//instance.testCase2();
		//instance.testCase3();
	}

}
