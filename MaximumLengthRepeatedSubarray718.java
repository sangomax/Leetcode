import java.util.*;

public class MaximumLengthRepeatedSubarray718 {

    public int findLength(int[] nums1, int[] nums2) {
        int[][] matrix = new int[nums1.length + 1][nums2.length + 1];
        int maxLength = 0;

        for(int n1 = 0; n1 < nums1.length; n1++) {

            for(int n2 = 0; n2 < nums2.length; n2++) {

               if (nums1[n1] == nums2[n2]) {
                       matrix[n1 + 1][n2 + 1] = 1 + matrix[n1][n2];
               }

            }

        }


        for(int x = 0; x <= nums1.length; x++) {
            for(int y = 0; y <= nums2.length; y++) {
                if (matrix[x][y] > maxLength) {
                    maxLength = matrix[x][y];
                }
            }
        }


        return maxLength;
    }

    public static void main(String[] args) {
        MaximumLengthRepeatedSubarray718 obj = new MaximumLengthRepeatedSubarray718();
        int nums1[] = {1,2,3,2,1};
        int nums2[] = {3,2,1,4};
        int r = obj.findLength(nums1,nums2);
        System.out.println(r);
    }

}
