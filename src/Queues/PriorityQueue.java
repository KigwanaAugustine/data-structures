package Queues;

import java.util.Arrays;

public class PriorityQueue {
    int capacity;
    int items[];
    int count;

    public PriorityQueue(int capacity){
        this.capacity = capacity;
        this.items = new int[capacity];
        this.count = 0;
    }

    public void add(int value){
        if(isFull())
            throw new IllegalStateException("Queue is full. Can't add new values!");

        int i = shiftValuesToInsert(value);
        items[i] = value;
        count++;
    }

    public int remove(){
        if (isFull()) 
            throw new IllegalStateException("Queue is empty!");
        
        return items[--count];
    }

    private int shiftValuesToInsert(int value) {
        int i = count - 1;
        for(; i > 0; i--){
            if (value < items[i]) {
                items[i + 1] = items[i];
            } else 
                break;
        }
        return i + 1;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == capacity;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);

        pq.add(5);
        pq.add(6);
        pq.add(7);
        pq.add(8);

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
        // System.out.println(pq.toString());
    }
}
