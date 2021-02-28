package com.yanxml.letcode.algorithm.a395;

import java.util.ArrayList;
import java.util.List;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 
 * 做了2-3小时。 终于OJ了. 好难. 使用分冶 递归法完成.
 * 
 * 要点在于 
 * 1. 滑动窗块。 及时判断满足条件都情况  如何滑动窗块？
 * 
 * 这题都难点在于2端都可以进行滑动.
 * 
 * 2. 什么情况下进行清零操作.s
 * Author: sean Date:Feb 27, 202111:16:07 PM
 */

public class LongestSubstring {
	static final char charArray[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	// 最后还是用分冶法 递归实现吧.汗.
	public static int longestSubstring(String s, int k) {
		return operate(s,k);
	}
	
	/**
	 * 分冶递归操作.
	 * 
	 * */
	public static int operate(String s, int k) {
		// 递归结束条件
		if(s.length() < k) {
			return 0;
		}
		int result = 0;
		List<String> subStringList = new ArrayList<>();
		int []countNum = new int[26];
		// 第一次扫描 统计次数
		for(int i=0; i<s.length(); i++) {
			countNum[s.charAt(i) - 'a'] ++; 
		}
		// 第二次顺序扫描 拆分
		int frontIndex = 0;
		for(int i=0; i<s.length(); i++) {
			if(countNum[s.charAt(i)-'a'] < k) {
				// 前一个结点就一个元素
				if(frontIndex == i) {
					frontIndex ++;
				}else {
					// 注意点1 - 结束条件
					// Returns a string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1.
					// 注意substring子串的范围
					subStringList.add(s.substring(frontIndex, (i) ));
					frontIndex = i+1;
				}
				
			}
		}
		// 防止"bbaaa"这样的情况出现 即 后续"aaa"也是一个末尾字串的情况
		// 特别注意这边结束条件的判断
		if(frontIndex < s.length() && frontIndex >0 ) {
			subStringList.add(s.substring(frontIndex));
		}
		// 第三次扫描 递归判断 - frontIndex == 0表示头指针没动过. 整个满足条件.
		if(subStringList.size() == 0 && frontIndex == 0) {
			// 此String就满足条件
			result = s.length();
		}else {
			// 使用子串递归 - 寻找最大值
			for(int i=0;i<subStringList.size();i++) {
				int tmpResult =  operate(subStringList.get(i), k);
//				if(tmpResult > result) {
//					result = tmpResult;
//				}
				result = tmpResult > result ? tmpResult : result;
			}
		}
		return result;
		
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
	
	//"bbaaacbd" - 3
	public static void testCase3() {
		String str = "bbaaacbd";
		int k = 3;
		System.out.println(longestSubstring(str,k));
	}
	// "baaabcb" - 3 / result 3
	public static void testCase4() {
		String str = "baaabcb";
		int k = 3;
		System.out.println(longestSubstring(str,k));
	}
	
	// "weitong"-2 / result 0
	public static void testCase5() {
		String str = "weitong";
		int k = 2;
		System.out.println(longestSubstring(str,k));
	}
	
	public static void main(String[] args) {
		// testCase1();
		// testCase2();
		// testCase3();
		// testCase4();
		testCase5();
	}

}
