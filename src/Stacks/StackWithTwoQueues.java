package Stacks;

import java.util.ArrayDeque;

public class StackWithTwoQueues{
    private ArrayDeque<Integer> queue1;
    private ArrayDeque<Integer> queue2;

    public StackWithTwoQueues(){
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int value){
        queue1.addLast(value);
    }

    public int pop(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty !");
        }

        while (!queue1.isEmpty()) {
            queue2.addFirst(queue1.removeFirst());
        }
        return queue2.removeFirst();
    }

    public int size(){
        return queue1.size() + queue2.size();
    }

    public int peek(){
        while (!queue1.isEmpty()) {
            queue2.addFirst(queue1.removeFirst());
        }
        return queue2.getFirst();
    }

    public boolean isEmpty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }


    public static void main(String[] args) {
        StackWithTwoQueues stack = new StackWithTwoQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        
    }
}