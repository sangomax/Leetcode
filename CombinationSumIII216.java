import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        if(k <= 0 ) { return result; }

        combinationSum3Helper(n, k,new ArrayList<Integer>(), 1, 0);

        return result;

    }

    public void combinationSum3Helper(int n, int k,List<Integer> list, int num, int sum) {

        if(list.size() == k) {
            if(sum == n) {
                result.add(new ArrayList<>(list));
            }
            return;
        } else if(num > n) {
            return;
        }

        if(list.size() < k) {
            if (num <= 9) {
                list.add(num);
                combinationSum3Helper(n, k, list, num + 1, sum + num);
                list.remove(list.size() - 1);
            }
        }
        if (num < 9) {
            num++;
            combinationSum3Helper(n,k,list,num, sum);

        }
    }

    public static void main(String[] args) {
        CombinationSumIII216 obj = new CombinationSumIII216();
        System.out.println(obj.combinationSum3(4,24));
    }
}
