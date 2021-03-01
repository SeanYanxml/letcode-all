package com.yanxml.letcode.algorithm.a1178;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 1178. 猜字谜
* https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
*
* Author: sean
* Date:Mar 2, 202112:14:14 AM
*/

public class FindNumOfValidWords {

	// 使用布隆表达式进行位运算.
	
		// 基础字母 从a开始计算
		static char BASE_CHAR = 'a';
		static int ONE = 0x0000000000000001;
		
		static int hardArray[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		static Map<Integer,Integer> hardNumMap = new HashMap<>();
		
		// 26个小写字母 8*3=24 8*4=32  所以基本上需要4个字节进行存储
		// 将数字的第i位设置为1
		// 1. Map 普通判别法
		public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
			
			initHardMap();
			int [] wordsList = new int[words.length];
			Map<Integer,Map<Integer,Integer>> puzzleMap = new HashMap<>(); 
			int [] puzzlesList = new int[puzzles.length];

			Integer resultList[] = new Integer[puzzles.length];
			// 初始化resultList
			for(int i=0; i<resultList.length; i++) {
				resultList[i] = 0;
			}
			
			// 初始化WordsList - 塞入数据
			for(int i=0; i<words.length; i++) {
				wordsList[i] = exchangeStringToInteger(words[i]);
			}
			
			for(int i=0; i<puzzlesList.length; i++) {
			// 初始化PuzzleList - 塞入数据
				puzzlesList[i] = exchangeStringToInteger(puzzles[i]);
				if(null == puzzleMap.get(puzzles[i].charAt(0)-'a')) {
					puzzleMap.put((puzzles[i].charAt(0)-'a'), new HashMap<Integer,Integer>());
				}
				puzzleMap.get(puzzles[i].charAt(0)-'a').put(i,puzzlesList[i]);
			}
			
			for(Map.Entry<Integer, Map<Integer,Integer>> entry: puzzleMap.entrySet()) {
				// 头字母
				int firstWordChar = entry.getKey();
				// 头字母相同的puzzle字符串
				Map<Integer,Integer> partialEntryMap = entry.getValue();
				
				List<Integer> tmpWordsList = new ArrayList<>();
				for(int i=0;i<wordsList.length ;i++) {
					if(isFirstWordFit(wordsList[i], firstWordChar)) {
						tmpWordsList.add(wordsList[i]);
					}
				}
				
				// 对partialEntryMap进行操作
				for(Map.Entry<Integer, Integer> partialEntry: partialEntryMap.entrySet()) {
					int puzzleIndex = partialEntry.getKey();
					int puzzleInt = partialEntry.getValue();
					for(int i=0;i<tmpWordsList.size();i++) {
						if(isWordAllInPuzzle(tmpWordsList.get(i),puzzleInt)) {
							// resultList[puzzleIndex];
							resultList[puzzleIndex]++;
						}
					}
				}
			}
			
			return Arrays.asList(resultList);
		}
		
		public static boolean isFirstWordFit(int wordInt, int firstWordIndex) {
			int bitFlag = wordInt & (ONE << firstWordIndex);
			if(bitFlag != 0) {
				return true;
			}
			return false;
		}
		
		// 校验方法 - 判断是否符合校验规则
		public static boolean isWordAllInPuzzle(int wordsInt, int puzzleInt) {
			boolean flag = false;
			if((wordsInt & puzzleInt)== wordsInt) {
				// 单词 word 中的每一个字母都可以在谜面 puzzle 中找到.
				// 位小 ,则表示 有位没有匹配上
				flag = true;
			}
			return flag;
		} 
		
		public static Integer exchangeStringToInteger(String str){
			Integer result = 0;
			int []tmpArray = new int[26];
			// char []strArray = str.toCharArray();
			for(int i=0; i < str.length(); i++) {
				tmpArray[(str.charAt(i) - 'a')] = 1;
			}
			// 将数组转变为需要的数字
			for(int i=0; i<tmpArray.length;i++) {
				if(tmpArray[i]==1) {
					result = result + (hardNumMap.get(i));
					// result = result + (ONE << i);
				}
			}
			return result;
		}
		
		
		// 优化点5 - hardmap初始化
		public static void initHardMap() {
			for(int i=0;i<hardArray.length;i++) {
				hardNumMap.put(i, ONE<<i);
			}
		}
}
