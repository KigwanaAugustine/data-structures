package Stacks;

import java.util.Stack;
import java.util.Arrays;
import java.util.List;

public class Main {

    private final List<Character> leftBrackets 
            = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets 
            = Arrays.asList(')', '>', ']', '}');

    public String reverse(String input){
        Stack<Character> stack = new Stack<>();

        //add all characters in the string to a stack
        for(char character : input.toCharArray())  stack.push(character);

        //pop each character into another string and return that new string
        var reversedString = new StringBuffer(); 
        while (!stack.empty()) reversedString.append(stack.pop());

        return reversedString.toString();
    }

    public boolean isLeftBracket(char ch){
        if(leftBrackets.contains(ch)) return true;
        else return false;
    }

    public boolean isRightBracket(char ch){
        if(rightBrackets.contains(ch)) return true;
        else return false;
    }

    public boolean bracketsMatch(char left, char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    public boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();

        for (char character : input.toCharArray()) {

            if(isLeftBracket(character)) stack.push(character);

            if(isRightBracket(character)){
                if(stack.empty()) return false;
                
                var top = stack.pop();
                if(!bracketsMatch(top, character)) return false;
            } 
        }

        return stack.empty();
    }


    public static void main(String[] args) {
        var test = new Main();
        System.out.println(test.isBalanced("(this expression>>"));
    }
}
