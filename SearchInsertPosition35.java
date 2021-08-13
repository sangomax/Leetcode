public class SearchInsertPosition35 {

    public int searchInsert(int[] nums, int target) {

        if(target <= nums[0]) {
            return 0;
        }
        if(target >= nums[nums.length - 1]) {
            return target > nums[nums.length - 1] ? nums.length : nums.length - 1;
        }

        int start = 0;
        int end = nums.length - 1;
        int half = 0;
        while(start <= end) {

            half = (start + end) / 2;
            if(target == nums[half]) {
                return half;
            } else if(nums[half] < target) {
                start = half + 1;
            } else {
                end = half - 1;
            }

        }


        if (target > nums[half]) {
            return half + 1;
        } else if (half > 0) {
            if(target < nums[half]) {
                return half;
            } else {
                return half - 1;
            }
        } else {
            return 0;
        }


    }


    public static void main(String[] args) {
        SearchInsertPosition35 obj = new SearchInsertPosition35();
        int i = obj.searchInsert(new int[]{1,3}, 3);
        System.out.println(i);
    }
}
