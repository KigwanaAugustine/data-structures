package LinkedLists;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private class Node{
        private int item;
        private Node next;

        public Node(int item){
            this.item = item;
        }
    }

    public LinkedList(int item){
        first = new Node(item);
        last = first;
        size++;
    }

    private void addFirst(int item){
        var node = new Node(item);
        
        //check if list is empty
        if (isEmpty()) {
           first = last = node;
        }else{
            node.next = first;
            first = node;
        }
        size++;
    }

    private void addLast(int item){
        var node = new Node(item);

        //check if list is empty
        if (isEmpty()) {
            first = last = node;
        }else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public int indexOf(int item){
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.item == item) {
                return index;
            }else{
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    public boolean contains(int item){
       return indexOf(item) != -1;
    }


    public void removeFirst(){

        if (isEmpty()) 
            throw new NoSuchElementException();
        
        //when linkedlist only has one element
        if (first == last) {
            first = last = null;
        }else{
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;

    }

    public void removeLast(){
        
        if (isEmpty()) 
            throw new NoSuchElementException();
        
        //when linkedlist has only one element
        if (first == last) {
            first = last = null;
        }else{
            var previous = getPrevious(last);
            last = previous;
            previous.next = null;
        }

        size--;

    }

    private Node getPrevious(Node node){
        var current = first;
        
        while (current != null) {
            if(current.next == node) return current;
            current = current.next;
        }

        return null;
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];

        var current = first;
        int index = 0;

        while(current != null){
            array[index++] = current.item;
            current = current.next; 
        }

        return array;
    }

    public void reverse(){

        if(isEmpty()) return;

        var current = first;
        Node previous = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        //update first & last pointers
        last = first;
        first = previous;
    }

    public Node getKthFromTheEnd(int k){
        
        var firstPointer = first;
        var secondPointer = first;

        if (isEmpty() || k <= 0) {
            return null; //Invalid input or an empty list 
        }

        //move first pointer by k positions
        for(int i = 0; i < k; i++){
            if (firstPointer == null) {
                return null; //K is greater than the length of the list 
            }
            firstPointer = firstPointer.next;
        }

        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return secondPointer;
    }

    private void printMiddle(){

        if (isEmpty()) throw new IllegalStateException();

        var a = first;
        var b = first;

        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }

        if (b == last) 
            System.out.println(a.item);
        else
            System.out.println(a.item + ", " + a.next.item);

    }

    public boolean hasLoop() {
        Node slowPointer = first;
        Node fastPointer = first;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            // If there is a loop, the slow and fast pointers will meet at some point
            if (slowPointer == fastPointer) {
                return true;
            }
        }

        // If the loop exits, there is no loop in the linked list
        return false;
    }
    private void print() {
        Node n = first;
    
        // Iterate through the linked list
        while (n != null) {
            System.out.println(n.item);
            n = n.next;
        }
    }
    

    private boolean isEmpty(){
        return first == null;
    }

    public static void main(String[] args) {
        var list = new LinkedList(10);
        list.addFirst(5);
        list.addFirst(1);
        list.addLast(100);
        list.addFirst(-100);
        list.addFirst(200);
        list.print();

        System.out.println();
        list.printMiddle();
    }
}
