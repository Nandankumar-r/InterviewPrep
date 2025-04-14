package CTCI.Stacks;

import java.util.LinkedList;
import java.util.Queue;

class MyStackQueue<T> {
    Queue<T> queue = new LinkedList<>();

    public void push(T x) {
        queue.add(x);
        int size = queue.size();
        while (size-- > 1) {
            queue.add(queue.remove());
        }
    }

    public T pop() {
        return queue.remove();
    }

    public T top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

