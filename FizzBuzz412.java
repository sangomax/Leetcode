import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            boolean isDivisibleBy3 = (i % 3 == 0);
            boolean isDivisibleBy5 = (i % 5 == 0);
            if (isDivisibleBy3 && isDivisibleBy5) {
                results.add("FizzBuzz");
            } else if (isDivisibleBy3) {
                results.add("Fizz");
            } else if (isDivisibleBy5) {
                results.add("Buzz");
            } else {
                results.add(String.valueOf(i));
            }
        }

        return results;
    }
}
