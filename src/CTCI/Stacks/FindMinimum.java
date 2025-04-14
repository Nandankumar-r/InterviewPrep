package CTCI.Stacks;

import CTCI.dataStructures.MyStack;

public class FindMinimum {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(6);
        stack.push(1);
        stack.push(5);
        stack.push(1);
        System.out.println(stack.min());
    }

    public static class MinStack extends MyStack<Integer> {
        MyStack<Integer> minStack;

        public MinStack() {
            minStack = new MyStack<>();
        }

        @Override
        public void push(Integer item) {
            if (item <= min()) {
                minStack.push(item);
            }
            super.push(item);
        }

        @Override
        public Integer pop() {
            Integer item = super.pop();
            if (item == min()) {
                minStack.pop();
            }
            return item;
        }

        public Integer min() {
            if (minStack.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return minStack.peek();
            }
        }
    }

}
