import java.util.ArrayList;
import java.util.Collections;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {
        ArrayList<Integer> subStringSize = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            ArrayList<String> subString = new ArrayList<>();
            subString.add(s.substring(i, i+1));
            if (s.length() > 1) {
                for (int j = i+1; j < s.length(); j++) {
                    String nextChar = s.substring(j, j+1);
                    if(!subString.contains(nextChar)) {
                        subString.add(nextChar);
                    } else {
                        break;
                    }
                }
            }
            subStringSize.add(subString.size());
        }

        Collections.sort(subStringSize);

        return subStringSize.size() > 0 ? subStringSize.get(subStringSize.size() -1) : 0;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 obj = new LongestSubstringWithoutRepeatingCharacters3();
        int b = obj.lengthOfLongestSubstring("");
        System.out.println(b);
    }

}
