import java.util.ArrayList;

public class RemoveDuplicatesSortedArray26 {

    public int removeDuplicates(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(i==0) {
                list.add(nums[i]);
            } else if(nums[i] != nums[i-1]){
                list.add(nums[i]);
            }
        }
        int count = 0;
        for (int item: list) {
            nums[count] = item;
            count++;
        }

        return list.size();
    }

}
