import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JumpGameII45 {

    public int jump(int[] nums) {

        int currIndex = 0;
        int maxIndex = 0;
        int jumps = 0;

        for(int i=0;i<nums.length-1;i++)
        {
            if(i + nums[i] > maxIndex)
            {
                maxIndex = i + nums[i];
            }

            if(i == currIndex)
            {
                currIndex = maxIndex;
                jumps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII45 obj = new JumpGameII45();
        System.out.println(obj.jump(new int[]{
                2,3,1,1,4}));
    }
}
