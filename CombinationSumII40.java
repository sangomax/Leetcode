import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII40 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        if(target < candidates[0]) { return result; }

        combinationSum2Helper(candidates, new ArrayList<Integer>(), target, 0, 0);

        return result;
    }

    public void combinationSum2Helper(int[] candidates, List<Integer> list, int target, int sum, int index) {

        if(sum > target) {
            return;
        } else if(sum == target) {
            ArrayList<Integer> temp = new ArrayList<Integer>(list);
            Collections.sort(temp);
            if(!result.contains(temp)) {
                result.add(temp);
            }
            return;
        } else if(index >= candidates.length) {
            return;
        }

        int prev = -1;
        for(int i = index; i < candidates.length ; i++ ) {
            if (prev != candidates[i]) {
                list.add(candidates[i]);
                combinationSum2Helper(candidates, list, target, sum + candidates[i], i+1);
                list.remove(list.size() - 1);
            }
            prev = candidates[i];
        }

    }

    public static void main(String[] args) {
        CombinationSumII40 obj = new CombinationSumII40();
        System.out.println(obj.combinationSum2(new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12},27));
    }

}
