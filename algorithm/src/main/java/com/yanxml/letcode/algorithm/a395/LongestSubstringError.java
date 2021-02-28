package com.yanxml.letcode.algorithm.a395;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Author: sean Date:Feb 27, 202111:16:07 PM
 */

public class LongestSubstringError {
	static final char charArray[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static int longestSubstring(String s, int k) {
		// 准备一个数组用来计算数组的长度
		int exitsTimes[] = new int[26];
		for(int i=0;i<s.length();i++) {
			exitsTimes[(s.charAt(i)-'a')]++;
		}
		// 判断有哪些字母是没有到k个的 - 
		// 感觉不需要通过set数据结构也可以 直接通过数组就行了
		Set<Character> timeNotFixCharSet = new HashSet<Character>();
		for(int i=0; i<exitsTimes.length;i++) {
			if(exitsTimes[i]<k) {
				timeNotFixCharSet.add(charArray[i]);
			}
		}
		// 计算最大长度
		int resultLong = 0, tmpLong=0;
		for(int i=0;i<s.length();i++) {
			if(timeNotFixCharSet.contains(s.charAt(i))) {
				tmpLong = 0;
			}else {
				tmpLong++;
			}
			// 感觉不用每次都进行判断 后续会对判断进行优化
			if(tmpLong > resultLong) {
				resultLong = tmpLong;
			}
		}
		return resultLong;
	}
	
	/**
	 * "aaabb"
	 * 3
	 * */
	public static void testCase1() {
		String str = "aaabb";
		int k = 3;
		System.out.println(longestSubstring(str,k));
	}

	public static void testCase2() {
		String str = "ababacb";
		int k = 3;
		System.out.println(longestSubstring(str,k));
	}
	
	public static void main(String[] args) {
		testCase2();
	}

}
