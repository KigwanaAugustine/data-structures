package Stacks;

public class DoubleStackedArray {
    private int capacity;
    private int[] array;
    private int top1;
    private int top2;

    public DoubleStackedArray(int capacity){
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top1 = -1;
        this.top2 = capacity;
    }

    public void push1(int value){
        if (isFull1()) {
            throw new StackOverflowError("Can't push , stack 1 is full.");
        }
        array[++top1] = value;
    }



    public void push2(int value){
        if (isFull2()) {
            throw new StackOverflowError("Can't push , stack 2 is full.");
        }
        array[--top2] = value;
    }

    public int pop1(){
        if (isEmpty1()){
            throw new IllegalStateException("Can't pop, stack 1 is empty.");
        }
        return array[top1--];
    }

    public int pop2(){
        if (isEmpty2()){
            throw new IllegalStateException("Can't pop, stack 2 is empty.");
        }
        return array[top2++];
    }

    public boolean isFull1() {
       return ++top1 == top2;
    }

    public boolean isFull2() {
       return --top2 == top1;
    }
    
    public boolean isEmpty1(){
        return top1 == -1;
    }

    public boolean isEmpty2(){
        return top2 == capacity;
    }

    public static void main(String[] args) {

        DoubleStackedArray twoStacks = new DoubleStackedArray(5);

        twoStacks.push1(1);
        twoStacks.push1(2);
        twoStacks.push2(3);
        twoStacks.push2(4);
        // twoStacks.push2(5);

        System.out.println("Pop from Stack 1: " + twoStacks.pop1()); // Output: 2
        System.out.println("Pop from Stack 2: " + twoStacks.pop2()); // Output: 5
    }

}
