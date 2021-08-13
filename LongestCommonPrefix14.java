import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        strs = setSmallToFirst(strs);
        String result = "";
        boolean flag = true;
        String temp = "";
        int count = 0;
        if(strs.length > 1 && strs[0].length() > 0) {
            do {
                temp = strs[0].substring(count, count + 1);
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() > 0 && strs[i].substring(count, count + 1).equals(temp)) {
                        continue;
                    } else {
                        temp = strs[i].substring(0, count);
                        flag = false;
                        break;
                    }
                }

                count++;


            } while (flag && count < strs[0].length());

            if(flag) {
                return strs[0];
            } else {
                result += temp;
            }

        } else {
            result += strs[0];
        }



        return result;
    }

    private String[] setSmallToFirst(String[] strs){
        for (int i=1; i < strs.length; i++){
            if(strs[0].length() > strs[i].length()) {
                String temp = strs[0];
                strs[0] = strs[i];
                strs[i] = temp;
            }
        }

        return strs;
    }

    public static void main(String[] args) {
        LongestCommonPrefix14 obj = new LongestCommonPrefix14();
        String[] input = {"flower","flower","flower","flower"};
        String r = obj.longestCommonPrefix(input);
        System.out.println(r);
    }
}
