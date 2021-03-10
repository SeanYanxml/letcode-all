package com.yanxml.letcode.algorithm.a1047;

/**
 *
 * Author: sean 
 * Date:Mar 9, 202111:37:32 PM
 */

public class RemoveDuplicates2 {
	/**
	 * 使用递归
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
	
	
	public String removeDuplicatesMethod2(String S) {
		int length = S.length();
		int[] single = new int[S.length()];
		
		int front=0;
		int end = front+1;
		
		while(front>=0 && end<=(length-1)) {
			// 判断当前坐标
			if(S.charAt(front) == S.charAt(end)) {
				single[front] = single[end] = 1;
				front--;
				while(front >=0  && single[front]==1 ) {
					front--;
				}
				if(front <0) {
					// 如果 front<0 则进行重置操作.
					front = end+1;
					end = end+2;
				}else {
					// 否则顺位走一格即可
					end++;
				}
			}else {
				front++;
				while(single[front]==1 ) {
					front++;
				}
				end++;
			}
			// 更换坐标值
			// 状况1 front-- end++
			// 状况2 front++ end++
			// 
		}
		
		// 拼接字符串
		StringBuilder resultStr = new StringBuilder();
		for(int i=0; i<single.length;i++) {
			if(single[i] == 0) {
				resultStr.append(S.charAt(i));
			}
		}
		return resultStr.toString();

	}
	
	// "aaaaaaaa"
	public void testMethod1() {
		String str = "aaaaaaaa";
		String result = removeDuplicatesMethod(str);
	}
	
	public static void main(String []args) {
		RemoveDuplicates2 demo = new RemoveDuplicates2();
		demo.testMethod1();
	}
}
