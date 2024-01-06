package Queues;

import java.util.LinkedList;

public class LinkedListQueue {
    LinkedList<Integer> list = new LinkedList<>();

    public void enqueue(int value){
        list.add(value);
    }

    public int dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. No value to dequeue !");
        }
        return list.removeFirst();
    }

    public int peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. No value to peek !");
        }
        return list.getFirst();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        
        System.out.println(queue.peek());


    }
}
