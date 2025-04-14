package CTCI.Stacks;

import CTCI.dataStructures.MyStack;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {
    List<MyStack<Integer>> stacks = new ArrayList<>();
    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity= capacity;
    }

    public void push(int value) {
        MyStack<Integer> last = getLastStack();
        if (last != null && last.size() < capacity) {
            last.push(value);
        } else {
            MyStack<Integer> stack = new MyStack<>();
            stack.push(value);
            stacks.add(stack);
        }
    }

    public int pop() {
        MyStack<Integer> last = getLastStack();
        int value = last.pop();
        if (last.isEmpty()) stacks.remove(stacks.size() - 1);
        return value;
    }

    private MyStack<Integer> getLastStack() {
        if (stacks.isEmpty()) return null;
        return stacks.get(stacks.size() - 1);
    }

    public int popAt(int index) {
        return stacks.get(index).pop();
    }

}

