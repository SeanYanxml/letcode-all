package com.yanxml.letcode.algorithm.exam.e20210307.a5699;

/**
*
* Author: sean
* Date:Mar 7, 202111:22:48 AM
*/

public class CountRestrictedPaths {
	// 1. 构建权重矩阵 [n-1][3-1]
	// 2. 构建每个结点最短路径 distanceToLastNode
	// 3. 从1-n 获取可行的路径类型.
	 public int countRestrictedPaths(int n, int[][] edges) {
		 int resultNum = 0;
		 // n*n 矩阵
		 int distance[][] = new int[n][n];
		 // n 每个结点的distanceToLastNode矩阵
		 int distanceToLastNode[] = new int[n];
		 
		 // 1. 构建权重矩阵
		 for(int i=0;i<edges.length;i++) {
			 // 将传入的数据进行拆分
			 int firstNode = edges[i][0];
			 int secondNode = edges[i][1];
			 int weight = edges[i][2];
			 // 无向图 所以赋值2次
			 distance[firstNode][secondNode] = weight;
			 distance[secondNode][firstNode] = weight;
		 }
		 
		 // 2. 计算结点值 distanceToLastNode
		 // 最后一个值就是自己 自己->自己为0
		 distanceToLastNode[n-1] = 0;
		 // 这边是一个动态规划问题. 使用前面的distanceToLastNode来计算后面的值
		 
		 // i结点到n结点的最短路径不一定是直接相连的 这个例子给出了答案
		 for(int i=n-2;i>=0;i++) {
			 
		 }
		 
		 return resultNum;
	 }
	 
	 public int finDistanceToLastNode(int distance[][],int distanceToLastNode[],int frontIndex, int endIndex) {
		 // 先从 endIndex 到所有存在的结点i -> distanceToLastNode(i)
		 return 0;
	 }
	 

}
