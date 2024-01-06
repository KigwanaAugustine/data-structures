package Queues;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    public ArrayQueue(int capacity){
        this.capacity = capacity;
        items = new int[capacity];
        front = 0;
        count = 0;
        this.rear = -1;
    }

    //enqueue
    public void enqueue(int value){
        if(isFull()){
            throw new IllegalStateException("Can't add element. Queue is full");
        } else{
            items[(++rear) % capacity] = value;
        }
        count++;
    }
    //dequeue
    public int dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove element. Queue is empty");
        }
        items[front] = 0;
        count--;
        return items[(front++) % capacity];
    }
    //peek

    public boolean isFull(){
        return count == capacity;
    }

    public boolean isEmpty(){
        return count == 0;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println( queue.toString());
        queue.dequeue();
        queue.enqueue(6);
        queue.dequeue();
        System.out.println( queue.toString());
    }
}
