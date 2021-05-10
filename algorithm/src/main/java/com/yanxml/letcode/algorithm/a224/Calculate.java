package com.yanxml.letcode.algorithm.a224;

import java.util.Stack;

/**
*
* Author: sean
* Date:Mar 10, 202110:40:56 PM
*/

public class Calculate {
//	static Character []numbers = {'0','1','2','3','4','5','6','7','8','9'};
//	static Character []calculator = {'+','-'};
//	static Character spaceChar = ' ';
//	
//	// 1+(1-2)
//	// s = "(1+(4+5+2)-3)+(6+8)"
//	// 对于没有乘法和除法的方法来说 括号毫无作用
//	public int calculate(String s) {
//		long result = 0;
//		Stack stack = new Stack<>();
//		stack.push(0);
//		for(int i=0; i < s.length(); i++) {
//			// 1- 首先判断是否是数字
//			if(isNumber(s.charAt(i))) {
//				char tmpChar = s.charAt(i);
//				long tmpNum = 0;
//				while(i<s.length() && isNumber(s.charAt(i))) {
//					tmpNum = tmpNum*10+ (s.charAt(i)-'0');
//					i++;
//				}
//				char calChar = (char)stack.pop();
//				stack.push(tmpNum);
//			}
//			// 2- 判断运算符号
//			if(i<s.length()) {
//				if(isCalculate(s.charAt(i))) {
//					stack.push(s.charAt(i));
//				}else {}
//			}
//			if(i<s.length() && isCalculate(s.charAt(i))) {
//				stack.push(s.charAt(i));
//			}
//			// 3- 空格' ' 和'(' 和 ')' 不进行计算
//			if(i<)
//		}
//		// 随后对于Stack栈进行处理
//		while(!stack.isEmpty()) {
//			if(stack.size()==1) {
//				Object obj = stack.pop();
//				if(obj instanceof Long) {
//					// 数字
//					long firstNumber = (long) obj;
//					result = firstNumber+result;
//				}else if (obj instanceof Character){
//					// 操作符号
//					if((char)obj == '-') {
//						result = - result;
//					}else if((char)obj == '+') {
//						
//					}
//				}
//				break;
//			}
//			// 弹出数字
//			long number = (long) stack.pop();
//			// 弹出运算符号
//			char calculate = (char)stack.pop();
//			if(calculate == '+') {
//				result = result+number;
//			}else if(calculate == '-') {
//				result = result-number;
//			}
//		}
//		
//		return (int)result;
//
//    }
//	
//	// 判断是否是数字
//	public boolean isNumber(Character charWord) {
//		if(charWord>='0' && charWord<='9') {
//			return true;
//		}else {
//			return false;
//		}
//	}
//	
//	// 判断是否是数字
//	public boolean isSpace(Character charWord) {
//		if(charWord == spaceChar) {
//			return true;
//		}else {
//			return false;
//		}
//	}
//	
//	// 判断是否是计算符号
//	public boolean isCalculate(Character charWord) {
//		for(int i=0;i<calculator.length;i++) {
//			if(charWord.equals(calculator[i])) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	// 判断是否是括号
//	public boolean isKuoHao(Character charWord) {
//		if(charWord.equals('(') || charWord.equals(')')){
//			return true;
//		}
//		return false;
//	}
//
//	
//	public void testMethod1() {
//		// 1
//		String str1 = "1 + 1";
//		int number1 = calculate(str1);
//		System.out.println(number1);
//		
//		//2
//		String str2 = " 2-1 + 2 ";
//		int number2 = calculate(str2);
//		System.out.println(number2);
//		
//		//3
//		String str3 = "(1+(4+5+2)-3)+(6+8)";
//		int number3 = calculate(str3);
//		System.out.println(number3);
//		
//		// "2147483647" 超过范围 艹TM
//		
//	}
//	
//	public void testMethod2() {
//		// 1
//		String str1 = "2147483647";
//		int number1 = calculate(str1);
//		System.out.println(number1);
//		
//		// "2147483647" 超过范围 艹TM
//		
//	}
//	
//	// "- (3 + (4 + 5))" 傻逼玩意
//	public void testMethod3() {
//		// 1
//		String str1 = "- (3 + (4 + 5))";
//		int number1 = calculate(str1);
//		System.out.println(number1);
//		
//		// "2147483647" 超过范围 艹TM
//		
//	}
//	
//	
//	public static void main(String[] args) {
//		Calculate demo = new Calculate();
//		 demo.testMethod1();
//		 demo.testMethod2();
//		 demo.testMethod3();
//	}
}
