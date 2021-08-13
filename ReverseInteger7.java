import java.lang.reflect.Array;
import java.util.List;

public class ReverseInteger7 {
    public int reverse(int x) {
        char[] valueArray = String.valueOf(x).toCharArray();
        if(x > 0) {
            for(int i = 0; i < valueArray.length / 2; i++) {
                int temp = valueArray.length - i;
                char aux = valueArray[temp - 1];
                valueArray[temp - 1] = valueArray[i];
                valueArray[i] = aux;
            }
        } else {
            for(int i = 1; i <= valueArray.length / 2; i++) {
                int temp = valueArray.length - i;
                char aux = valueArray[temp];
                valueArray[temp] = valueArray[i];
                valueArray[i] = aux;
            }
        }

        String reverseValue = "";
        for(char letter: valueArray) {
            reverseValue += letter;
        }

        try{
            return Integer.valueOf(reverseValue);
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    public static void main(String[] args) {
        ReverseInteger7 obj = new ReverseInteger7();

        int r = obj.reverse(-1234);
        System.out.println(r);
    }
}
