import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        for (int m = 0; m < nums.length; m++) {

            for (int n = 0; n < m; n++) {

                if (nums[n] < nums[m] && dp[m] < (dp[n] + 1)) {
                    dp[m] = dp[n] + 1;
                }

            }

        }

        int[] dpSorted = Arrays.stream(dp).sorted().toArray();
        return dpSorted[nums.length - 1] + 1;
    }


    public static void main(String[] args) {
        LongestIncreasingSubsequence300 obj = new LongestIncreasingSubsequence300();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        int r = obj.lengthOfLIS(nums);
        System.out.println(r);
    }
}
