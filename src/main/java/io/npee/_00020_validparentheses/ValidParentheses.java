package io.npee._00020_validparentheses;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        // 길이는 짝수가 되어야겠지?
        // 스택이 필요할 듯(여는 괄호 담는 스택)
        // 닫는 괄호가 나올 때 까지 여는 괄호를 스택에 집어넣고 문자열의 문자를 하나씩 제거하자.
        // 닫는 괄호와 스택의 peek 값이 같으면 pop 해보자.
        // 짝이 안맞으면 false
        // 마지막에 스택 길이도 0이어야하고 남은 문자열도 없어야 한다.

        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        while(s.length() != 0) {
            char front = s.charAt(0);
            if (front == '(' || front == '{' || front == '[') {
                stack.push(front);
            } else if (stack.empty() && front == ')'
                    || stack.empty() && front == '}'
                    || stack.empty() && front == ']') {
                return false;
            } else if (!(front == ')' && stack.pop() == '('
                    || front == '}' && stack.pop() == '{'
                    || front == ']' && stack.pop() == '[')){
                return false;
            }
            s = s.substring(1);
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String question = "(){}}{";
        boolean isValid = isValid(question);
        System.out.println("\"" + question + "\" isValid? = " + isValid);
    }
}
