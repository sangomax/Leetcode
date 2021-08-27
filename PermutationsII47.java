import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationsII47 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<Integer> permutation = new ArrayList<>();

        permuteUniqueHelper(IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new)),
                new ArrayList<>(), nums.length);

        return result;

    }

    public void permuteUniqueHelper(List<Integer> nums, List<Integer> list, int size) {

        if(list.size() == size) {
            if(!result.contains(list)) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i = 0; i < nums.size(); i++) {
            list.add(nums.get(i));
            List<Integer> temp = new ArrayList<>(nums);
            temp.remove(i);
            permuteUniqueHelper(temp, list, size);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationsII47 obj = new PermutationsII47();
        System.out.println(obj.permuteUnique(new int[]{1,1,2}));
    }

}
