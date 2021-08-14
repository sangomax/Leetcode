import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses20 {

    public boolean isValid(String s) {

        char[] parenthesesArray = s.toCharArray();
        Stack list = new Stack();

        for(char parenthese : parenthesesArray) {
            switch (parenthese) {
                case ')' :
                    if(!list.isEmpty() && list.peek().equals('(')) {
                        list.pop();
                        continue;
                    }
                    return false;

                case '}' :
                    if(!list.isEmpty() && list.peek().equals('{')) {
                        list.pop();
                        continue;
                    }
                    return false;
                case ']' :
                    if(!list.isEmpty() && list.peek().equals('[')) {
                        list.pop();
                        continue;
                    }
                    return false;
                default:
                    list.push(parenthese);
            }
        }

        return list.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        ValidParentheses20 obj = new ValidParentheses20();
        System.out.println(obj.isValid("([)]"));
    }

}
