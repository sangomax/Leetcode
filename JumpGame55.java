public class JumpGame55 {

    public boolean canJump(int[] nums) {

        int maxIndex = 0;

        for(int i=0;i<nums.length-1;i++)
        {
            if(i + nums[i] > maxIndex)
            {
                maxIndex = i + nums[i];
            }

            if(maxIndex == i && nums[i] == 0) {
                return false;
            }
        }

        if(maxIndex >= nums.length - 1) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        JumpGame55 obj = new JumpGame55();
        System.out.println(obj.canJump(new int[]{
                1,0,1,0}));
    }

}
