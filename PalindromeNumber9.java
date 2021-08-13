public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        String xs = String.valueOf(x);

        int middle = xs.length() / 2;
        int size = 0;
        if (xs.length() % 2 == 0) {
            size = getSize(middle -1, middle, xs);
        } else {
            size = getSize(middle, middle, xs);
        }

        if(size == xs.length()) {
            return true;
        } else {
            return false;
        }

    }

    public int getSize(int i, int j, String s) {

        if (j >= s.length() ) {
            return 0;
        }

        int size = (i == j) ? -1 : 0;

        while(i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            size += 2;
            i--;
            j++;
        }

        return size;
    }
    public static void main(String[] args) {
        PalindromeNumber9 obj = new PalindromeNumber9();
        System.out.println(obj.isPalindrome(10));
    }
}
