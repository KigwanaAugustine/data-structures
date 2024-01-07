package Stacks;

import java.util.Arrays;

public class Stack {
    private int count; 
    private int[] items = new int[5];

    private int pop(){
        if (empty()) 
            throw new IllegalStateException();

        return items[--count];
    }

    private int peek(){
        if (empty())
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        
        return items[count -1];
    }

    private boolean empty(){
        return count == 0;
    }

    private void push(int item){
        if (count == items.length)
            throw new StackOverflowError();
        items[count++] = item;
    }

    @Override
    public String toString(){
        var itemsCopy = Arrays.copyOf(items, count);
        return Arrays.toString(itemsCopy);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
