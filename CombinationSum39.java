import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        if(target < candidates[0]) { return result; }

        combinationSumHelper(candidates, new ArrayList<Integer>(), target, 0, 0);

        return result;
    }

    public void combinationSumHelper(int[] candidates, List<Integer> list, int target, int sum, int index) {

        if(sum == target) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

            if (sum + candidates[index] <= target) {
                list.add(candidates[index]);
                combinationSumHelper(candidates, list, target, sum + candidates[index], index);
                list.remove(list.size() - 1);
            }
            if (index < candidates.length - 1) {
                index++;
                combinationSumHelper(candidates, list, target, sum, index);

            }

    }

    public static void main(String[] args) {
        CombinationSum39 obj = new CombinationSum39();
        System.out.println(obj.combinationSum(new int[]{7,3,9,6}, 6));
    }
}
