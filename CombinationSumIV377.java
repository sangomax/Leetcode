import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumIV377 {



    public int combinationSum4(int[] nums, int target) {

        List<Integer> dp = Arrays.asList(new Integer[target + 1]);

        Collections.fill(dp, -1);

        return combinationSum4Helper(nums, target, dp);
    }

    private int combinationSum4Helper(int[] nums, int target, List<Integer> dp) {

        if(target == 0) { return 1; }

        if(dp.get(target) != -1) { return dp.get(target); }

        int sum = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] <= target) {
                sum += combinationSum4Helper(nums, target - nums[i], dp);
            }
        }

        dp.set(target, sum);
        return sum;
    }


    public static void main(String[] args) {
        CombinationSumIV377 obj = new CombinationSumIV377();
        System.out.println(obj.combinationSum4(new int[]{1,2,3}, 4));
    }

}
