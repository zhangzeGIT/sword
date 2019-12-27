package com.zhangze.sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhangze on 2019/11/8
 * 30、包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 */
public class IncludeMain {
    List<Integer> minList = new ArrayList<>();
    int start = 0;
    List<Integer> stack = new LinkedList<>();

    public void push(int node) {
        if (start == 0) {
            minList.add(node);
        } else {
            if (minList.get(start - 1) < node) {
                minList.add(minList.get(start - 1));
            } else {
                minList.add(node);
            }
        }
        stack.add(node);
        start++;
    }

    public void pop() {
        if (start > 0) {
            start--;
            minList.remove(start);
            stack.remove(start);
        }
    }

    public int top() {
        return stack.get(start - 1);
    }

    public int min() {
        if (start > 0) {
            return minList.get(start - 1);
        }
        return 0;
    }

}
