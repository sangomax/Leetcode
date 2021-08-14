import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LongestValidParentheses32 {

    public int longestValidParentheses(String s) {

        char[] parenthesesArray = s.toCharArray();

        int maxSum = 0;
        int open = 0;
        int close = 0;


        for(char parenthese : parenthesesArray) {
            switch (parenthese) {
                case ')' :
                    close++;
                    break;
                case '(' :
                    open++;
                    break;

            }

            if(open == close) {
                maxSum = Math.max(maxSum, 2 * close);
            } else if(close>=open) {
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;

        for(int i = parenthesesArray.length - 1; i >= 0; i--) {
            switch (parenthesesArray[i]) {
                case ')' :
                    close++;
                    break;
                case '(' :
                    open++;
                    break;

            }

            if(open == close) {
                maxSum = Math.max(maxSum, 2 * open);
            } else if(open>=close) {
                open = 0;
                close = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        LongestValidParentheses32 obj = new LongestValidParentheses32();
        System.out.println(obj.longestValidParentheses("(()"));
    }

}
