package Queues;

import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public void enqueue(int value){
            stack1.push(value);
    }

    public int dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove element. Queue is empty");
        }
        moveStack1ToStack2();

        return stack2.pop();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.empty())
                stack2.push(stack1.pop());
        }
    }

    public int peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove element. Queue is empty");
        }
        moveStack1ToStack2();

        return stack2.peek();
    }

    public boolean isEmpty(){
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();

        queue.enqueue(5);
    }
}
