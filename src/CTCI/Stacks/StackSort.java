package CTCI.Stacks;

import CTCI.dataStructures.MyStack;

public class StackSort {
    public void sortStack(MyStack<Integer> input) {
        MyStack<Integer> tempStack = new MyStack<>();

        while (!input.isEmpty()) {
            int temp = input.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                input.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        // Optional: transfer back to original stack if needed
        while (!tempStack.isEmpty()) {
            input.push(tempStack.pop());
        }
    }

}
