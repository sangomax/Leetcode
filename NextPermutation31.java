import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextPermutation31 {

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int arr[], int i, int j){
        while(i<j) {
            swap(arr, i++, j--);
        }
    }

    public static void main(String[] args) {
        NextPermutation31 obj = new NextPermutation31();
        obj.nextPermutation(new int[]{2,1,3,4});
    }

}
