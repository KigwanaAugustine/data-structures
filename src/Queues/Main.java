package Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static int romanToInt(String s) {
        int integerEquivalent = 0;
        char[] stringArr = s.toCharArray();//convert s to an array
        for(int i = 0; i < stringArr.length; i++){
            System.out.println(stringArr[i]  + " IntegerEquivalent = " + integerEquivalent);
            switch(stringArr[i]){
                case 'I':{
                    if((i+1 < stringArr.length)){
                        if(stringArr[i+1] == 'V'){
                            integerEquivalent += 4; 
                            continue;
                        }
                        else if(stringArr[i+1] == 'X'){
                            integerEquivalent += 9;
                            continue;
                        }
                         
                    }
                    integerEquivalent += 1;
                    break;
                }
                  case 'X':{
                    if((i+1 < stringArr.length)){
                        if(stringArr[i+1] == 'L'){
                            integerEquivalent += 40;
                            continue;
                        }
                        else if(stringArr[i+1] == 'C'){
                            integerEquivalent += 90; continue;
                        }
                            
                    }
                    integerEquivalent += 10;
                    break;
                }
                  case 'C':{
                    if((i+1 < stringArr.length)){
                        if(stringArr[i+1] == 'D'){
                            integerEquivalent += 400;
                            continue;
                        }
                        else if(stringArr[i+1] == 'M'){
                            integerEquivalent += 900; continue;
                        }
                    }
                    integerEquivalent += 100;
                    break;
                }
                case 'V':{
                    if(i > 0 && (stringArr[i-1] == 'I'))
                        continue;
                    else
                        integerEquivalent += 5;
                    break;
                }
                case 'L':{
                    if(i > 0 && (stringArr[i-1] == 'X'))
                        continue;
                    else
                        integerEquivalent += 50;
                    break;
                }
                case 'D':{
                    if(i > 0 && (stringArr[i-1] == 'C'))
                        continue;
                    else
                        integerEquivalent += 500;
                    break;
                }
                case 'M':{
                    if(i > 0 && (stringArr[i-1] == 'C'))
                        continue;
                    else
                        integerEquivalent += 1000;
                    break;
                }
            }
        }
        return integerEquivalent;
    }

    public static void reverseFirstKElements(Queue<Integer> queue, int k){
        var queue1 = queue;
        Queue<Integer> queue2 = new ArrayDeque<>();

        Stack<Integer> stack = new Stack<>();
        //to-do: catch exception for k greater that size of queue

        for(int i = 0; i < k; i++){
            stack.push(queue1.remove());
        }

        while (! stack.empty()) {
            queue2.add(stack.pop());
        }

        while (! queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        while (! queue2.isEmpty()) {
            queue.add(queue2.remove());
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);


        reverseFirstKElements(queue, 3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); // Outputs: cherry, banana, apple
        }
        
    }
}
