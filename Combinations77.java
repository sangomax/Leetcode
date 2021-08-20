import java.util.ArrayList;
import java.util.List;

public class Combinations77 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        if(k <= 0 ) { return result; }

        combineHelper(n, k,new ArrayList<Integer>(), 1);

        return result;

    }

    public void combineHelper(int n, int k,List<Integer> list, int num) {

        if(list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        } else if(num > n) {
            return;
        }

        if(list.size() < k) {
            list.add(num);
            combineHelper(n,k,list,num + 1);
            list.remove(list.size() - 1);
        }
        if (num < n) {
            num++;
            combineHelper(n,k,list,num);

        }


    }

    public static void main(String[] args) {
        Combinations77 obj = new Combinations77();
        System.out.println(obj.combine(4,2));
    }

}
