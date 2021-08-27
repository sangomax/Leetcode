import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations46 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> permutation = new ArrayList<>();

        permuteHelper(IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new)),
                new ArrayList<>(), nums.length);

        return result;

    }


    public void permuteHelper(List<Integer> nums, List<Integer> list, int size) {

        if(list.size() == size) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.size(); i++) {
            list.add(nums.get(i));
            List<Integer> temp = new ArrayList<>(nums);
            temp.remove(i);
            permuteHelper(temp, list, size);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations46 obj = new Permutations46();
        System.out.println(obj.permute(new int[]{1,2,3}));
    }

}
