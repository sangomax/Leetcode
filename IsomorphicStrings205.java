import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IsomorphicStrings205 {

    public boolean isIsomorphic(String s, String t) {
        String codeS = "";
        String codeT = "";

        codeS = generatyCode(s);
        codeT = generatyCode(t);

        if (codeS.equals(codeT)) {
            return true;
        }

        return false;
    }

    public String generatyCode(String word) {
        String code = "";
        ArrayList<String> codes = new ArrayList<String>();

        for (int i = 0; i < word.length(); i++) {

            if (codes.contains(word.substring(i, i + 1))) {
                code = code + codes.indexOf(word.substring(i, i + 1));
            } else {
                codes.add(word.substring(i, i + 1));
                code = code + (codes.size() - 1);
            }

        }


        return code;
    }

    public static void main(String[] args) {
        IsomorphicStrings205 obj = new IsomorphicStrings205();
        boolean b = obj.isIsomorphic("foo", "bar");
        System.out.println(b);
        b = obj.isIsomorphic("paper", "title");
        System.out.println(b);
    }
}
