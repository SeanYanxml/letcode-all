package com.yanxml.letcode.algorithm.a1047;

/**
 *
 * Author: sean 
 * Date:Mar 9, 202111:37:32 PM
 */

public class RemoveDuplicates {
	/**
	 * 使用递归 - 优化
	 * 超时
	 * jhheljiljgblhkcigcckddgceehhbbmkjjehcfdhifddefddiefmfjccjlggmemjjhheljiljgblhkcigcckddgceehhbbmkjjehcfdhifddefddiefmfjccjlggmemj
	 * */
	public String removeDuplicatesMethod(String S) {
		return removeDuplicatesMethod(S,0);
	}
	
	public String removeDuplicatesMethod(String S, int startIndex) {
		String result = S;
		// 退无可退
		if(startIndex < 0) {
			startIndex = 0;
		}
		for(int i=startIndex;(i+1)<S.length();i++) {
			if(S.charAt(i)==S.charAt(i+1)) {
				result = removeDuplicatesMethod(S.substring(0,i)+S.substring(i+2),i-1);
				break;
			}
		}
		return result;	
	}
	
	
	/**
	 * 递归超时。
	 * */
	public String removeDuplicatesMethod2(String S) {
		String result = S;
		for(int i=0;(i+1)<S.length();i++) {
			if(S.charAt(i)==S.charAt(i+1)) {
				result = removeDuplicatesMethod2(S.substring(0,i)+S.substring(i+2));
			}
		}
		return result;
	}
	
	// "aaaaaaaa"
	public void testMethod1() {
		String str = "aaaaaaaa";
		String result = removeDuplicatesMethod(str);
	}
	
	public static void main(String []args) {
		RemoveDuplicates demo = new RemoveDuplicates();
		demo.testMethod1();
	}
}
