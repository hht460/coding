package com.hthu.jzoffer;

import java.util.Stack;

public class JZ05 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 当插入时，直接插入 stack1
    // 当弹出时，当 stack2 不为空，弹出 stack2 栈顶元素，如果 stack2 为空，将 stack1 中的全部数逐个出栈入栈 stack2，再弹出 stack2 栈顶元素
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 当 stack2 不为空，弹出 stack2 栈顶元素
        // 如果 stack2 为空，将 stack1 中的全部数逐个出栈入栈 stack2，再弹出 stack2 栈顶元素
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
