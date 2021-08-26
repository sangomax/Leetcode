import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpGameIII1306 {

    boolean[] visited;

    public boolean canReach(int[] arr, int start) {

        visited = new boolean[arr.length];
        Arrays.fill(visited, false);



        List<Integer> indexOfZero = new ArrayList<>();

        int count = 0;

        for(int num : arr) {
            if(num == 0) {
                indexOfZero.add(count);
            }
            count++;
        }

        canReachHelper(arr,start,visited,indexOfZero);


        for(int index: indexOfZero) {
           if (visited[index]) {
               return true;
           }
        }

        return false;

    }


    public void canReachHelper(int[] arr, int start, boolean[] visited, List<Integer> reach) {

        visited[start] = true;

        if(reach.contains(start)) { return; }

        if(start + arr[start] < arr.length) {
            if(!visited[start + arr[start]]) {
                canReachHelper(arr, start + arr[start], visited, reach);
            }
        }

        if(start - arr[start] >= 0) {
            if(!visited[start - arr[start]]) {
                canReachHelper(arr, start - arr[start], visited, reach);
            }
        }

    }


    public static void main(String[] args) {
        JumpGameIII1306 obj = new JumpGameIII1306();
        System.out.println(obj.canReach(new int[]{0,3,0,6,3,3,4 },6));
    }

}
