package CTCI.Stacks;

import CTCI.dataStructures.MyStack;

class MyQueueStacks<T> {
    MyStack<T> stackNewest = new MyStack<>();
    MyStack<T> stackOldest = new MyStack<>();

    public void add(T value) {
        stackNewest.push(value);
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }

    public boolean isEmpty() {
        return stackNewest.isEmpty() && stackOldest.isEmpty();
    }
}

