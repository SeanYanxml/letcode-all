package com.yanxml.letcode.algorithm.a705;

/**
* 705. 设计哈希集合
* https://leetcode-cn.com/problems/design-hashset/
* 
* 最终做法 - 布隆过滤器 
* 
* 1个int数据类型的数据。可以存储64个数字。 (2^63-1)数字需要多少数字?
* Author: sean
* Date:Mar 13, 202110:53:41 PM
*/

public class MyHashSet {
	/** Initialize your data structure here. */
	double factor = 0.75;
	int sum = 0;
	MyHashSet.Node numArray[] = null;
	int capacity = 0;
	int threshold = 0;

	public void init() {
		capacity = 16;
		// 官方使用769进行取模
		
		// 性能调优 leetcode有点硬核
		capacity = 1024 * 256;

		threshold = (int) (capacity * factor);
		numArray = new MyHashSet.Node [capacity];
	}
	
	// 判断是否满了
	public boolean isFull() {
		if(sum >= threshold) {
			return true;
		}
		return false;
	}
	
	// 扩充操作
	public void resize() {
		// 扩充计算值
		capacity = capacity * 2;
		threshold = (int) (capacity * factor);
		// 扩充整个数组
		MyHashSet.Node oldNumArray[] = numArray;
		numArray = new MyHashSet.Node [capacity];
		// i=0 放置到  0 / i+capacity2个位置上.
		for(int i=0;i<oldNumArray.length;i++) {
			MyHashSet.Node tmpNode = oldNumArray[i];
			MyHashSet.Node newNodeFirst = numArray[i];
			MyHashSet.Node newNodeSecond = numArray[i+(capacity/2)];

			while(null != tmpNode) {
				// 需要重新进行hashCode的计算 比如 16--> 32  “17和1” 的hash槽位置已经发生了改变
				int key = tmpNode.value;
				int haseCode = hashCode(key,capacity);
				if(haseCode>capacity/2) {
					// index = i
					if(newNodeFirst == null) {
						numArray[i] = tmpNode;
						newNodeFirst = tmpNode;
					}else {
						newNodeFirst.nextNode = tmpNode;
						newNodeFirst = newNodeFirst.nextNode;
					}
				}else {
					// index = i+capacity
					// index = i
					if(newNodeSecond == null) {
						numArray[i+(capacity/2)] = tmpNode;
						newNodeSecond = tmpNode;
					}else {
						newNodeSecond.nextNode = tmpNode;
						newNodeSecond = newNodeSecond.nextNode;
					}
				}
				tmpNode = tmpNode.nextNode;
			}
		}
	}
	
	
	// 查找
	public MyHashSet.Node search(int num){
		MyHashSet.Node resultNode = null;
		return resultNode;
	}
	
	// 计算hashCode值
	public int hashCodeOld(int num) {
		return num%capacity;
	}
	
	// 使用位运算 优化取模算法
	// 一般capacity都取 2^N
	public int hashCode(int num) {
		// return num & (capacity-1);
		return num & ((capacity-1)>>>16);
		
		
		// 为什么使用 ^运算符 (capacity-1)>>>16 
		// 下标范围如何保证？
		// return num ^ ((capacity-1)>>>16);
	}
	
	// 为了扩充准备
	public int hashCode(int num, int capacity) {
		return num%capacity;
	}
	
    public MyHashSet() {
    	init();
    }
    
    public void add(int key) {
    	if(isFull()) {
    		resize();
    	}
    	int hashCode = hashCode(key);
    	if(null == numArray[hashCode]) {
    		// 槽位置为空
    		numArray[hashCode] = new Node(key,null);
    		sum++;
    	}else {
    		// 0号位置不为空 简单使用链表进行实现
    		// 扫描时候还判断是否值相等
    		MyHashSet.Node tmpNode = numArray[hashCode];
    		MyHashSet.Node lastNode = null;
            boolean insertFlag = true;
    		while(null != tmpNode) {
    			if(tmpNode.value == key) {
    				insertFlag = false;
    				break;
    			}
    			lastNode = tmpNode;
    			tmpNode = tmpNode.nextNode;  			
    		}
    		// 扫描到最后都没找到 - 插入队尾
    		if(insertFlag) {
    			lastNode.nextNode = new MyHashSet.Node(key,null);
    			sum++;
    		}
    	}

    }
    
    public void remove(int key) {
    	int hashCode = hashCode(key);
    	if(null == numArray[hashCode]) {
    		// 槽位置为空
    		// 哈哈一般不会出现这种情况
    	}else if((null == numArray[hashCode].nextNode) && (key == numArray[hashCode].value)){
    		// 只有一个元素 删除即可
    		numArray[hashCode] = null; 
    		sum --;
     	}else {
     		// 扫描需要找到到元素 进行删除
    		MyHashSet.Node tmpNode = numArray[hashCode];
    		MyHashSet.Node lastNode = null;
    		
    		while(null != tmpNode) {
    			if(tmpNode.value == key) {
    				lastNode.nextNode = tmpNode.nextNode;
    				sum --;
    				break;
    			}   			
    			lastNode = tmpNode;
    			tmpNode = tmpNode.nextNode;   			
    		}
    		// 扫描到最后都没找到 - 没啥好删除的.
    	}
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	boolean flag = false;
    	int hashCode = hashCode(key);
		MyHashSet.Node tmpNode = numArray[hashCode];
		while(null != tmpNode) {
			if(tmpNode.value == key) {
				flag = true;
				break;
			}
		}
    	return flag;
    }
    
    static class Node{
    	public int value;
    	public Node nextNode;
    	
    	public Node(int value, Node nextNode) {
    		this.value = value;
    		this.nextNode = nextNode;
    	}
    }
}
