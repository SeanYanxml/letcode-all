package com.yanxml.letcode.algorithm.a232;

import java.util.Stack;

/**
* 232. 用栈实现队列
* https://leetcode-cn.com/problems/implement-queue-using-stacks/
* 
* 实现是在哟点蠢。每次需要把其中一个栈A -> 栈B 中写入数据。随后弹出栈B中最后一个数字。
* Author: sean
* Date:Mar 5, 202112:03:12 AM
*/

class MyQueue {

	Stack<Integer> stackOne = null;
	Stack<Integer> stackTwo = null;

    /** Initialize your data structure here. */
    public MyQueue() {
    	stackOne = new Stack<>();
    	stackTwo = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
		stackOne.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	rebalance();
    	if(!stackTwo.isEmpty()) {
    		return stackTwo.pop();
    	}else {
    		return 0;
    	}
    }
    
    /** Get the front element. */
    public int peek() {
    	rebalance();
    	if(!stackTwo.isEmpty()) {
    		return stackTwo.peek();
    	}else {
    		return 0;
    	}
    }
    
    // 当StackTwo为空时候 此时恰好需要pop或者peek操作 且stackone有值 就可以把值塞入stackTwo中
    public void rebalance() {
    	if(stackTwo.isEmpty() && !stackOne.isEmpty()) {
    		while(!stackOne.isEmpty()) {
    			stackTwo.push(stackOne.pop());
    		}
    	}
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return stackOne.isEmpty() && stackTwo.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
