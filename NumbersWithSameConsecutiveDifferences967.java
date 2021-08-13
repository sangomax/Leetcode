import java.util.ArrayList;

public class NumbersWithSameConsecutiveDifferences967 {

    public int[] numsSameConsecDiff(int n, int k) {

        ArrayList<String> result = numsSameConsecDiffHelper(n, k, "", new ArrayList<>());

        for(int i = result.size()-1; i >= 0; i--) {
            int num = Integer.valueOf(result.get(i));
            if(String.valueOf(num).length() != n) {
                result.remove(result.get(i));
            }
        }

        int[] resultInt = new int[result.size()];
        int count = 0;
        for(String num : result) {
            resultInt[count] = Integer.valueOf(num);
            count++;
        }

        return resultInt;
    }

    public ArrayList<String> numsSameConsecDiffHelper(int n, int k, String soFar, ArrayList<String> listInt) {
        if ( n == 0) {
            listInt.add(soFar);
            return listInt;
        } else {
            for ( int i = 0; i <= 9; i++) {
                if(soFar.length() == 0) {
                    soFar += i;
                    listInt = numsSameConsecDiffHelper(n-1,k,soFar,listInt);
                    soFar = "";
                } else {
                    if((Integer.valueOf(soFar.substring(soFar.length()-1,soFar.length())) + k) == i ||
                            (Integer.valueOf(soFar.substring(soFar.length()-1,soFar.length())) - k) == i) {
                        soFar += i;
                        listInt = numsSameConsecDiffHelper(n-1,k,soFar,listInt);
                        soFar = soFar.substring(0,soFar.length()-1);
                    }
                }

            }
            return listInt;
        }
    }

}
