import java.util.Collections;

public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {

        int mostWater = 0;
        int indexLarger = 0;

        int start = 0;
        int end = height.length - 1;

        do{
            if(height[start] < height[end]) {
                int water = height[start] * (end - start);
                if (mostWater < water) {
                    mostWater = water;
                }
                start++;
            } else {
                int water = height[end] * (end - start);
                if (mostWater < water) {
                    mostWater = water;
                }
                end--;
            }
        }while(start < end);



//        for(int i = 1; i < height.length; i++) {
//            if(height[indexLarger] < height[i]) {
//                indexLarger = i;
//            }
//        }
//
//        for(int j = 0; j < height.length; j++) {
//            if(j == indexLarger) { continue; }
//            if(j <= indexLarger ) {
//                if (height[j] * (indexLarger - j) > mostWater) {
//                    mostWater = height[j] * (indexLarger - j);
//                }
//            } else {
//                if(height[j] * (j - indexLarger) > mostWater) {
//                    mostWater = height[j] * (j - indexLarger);
//                }
//            }
//        }


//        for(int i = 0; i < height.length; i++) {
//            for(int j = i + 1; j < height.length; j++) {
//                if(height[i] <= height[j]) {
//                    if(height[i] * (j - i) > mostWater) {
//                        mostWater = height[i] * (j - i);
//                    }
//                } else {
//                    if(height[j] * (j - i) > mostWater) {
//                        mostWater = height[j] * (j - i);
//                    }
//                }
//            }
//        }

        return mostWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater11 obj = new ContainerWithMostWater11();
        System.out.println(obj.maxArea(new int[]{1,2,1}));
    }

}
