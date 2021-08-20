public class CountSay38 {

    public String countAndSay(int n) {

        String say = "1";


        if(n == 1) {
            return say;
        }

        String lastNum = "";
        int count = 0;
        int startIndex = 0;

        for(int i = 2; i <= n; i++) {
            String newSay = "";
            for(int j = 0; j < say.length(); j++) {

                String num = say.substring(j, j + 1);

                if (lastNum.isEmpty()) {
                    count++;
                    lastNum = num;
                } else if (lastNum.equals(num)) {
                    count++;
                } else {
                    newSay = newSay + count + lastNum;
                    lastNum = num;
                    count = 1;
                }

            }
            newSay = newSay + count + lastNum;
            say = newSay;
            count = 0;
            lastNum = "";
        }


        return say;
    }

    public static void main(String[] args) {
        CountSay38 obj = new CountSay38();
        System.out.println(obj.countAndSay(4));
    }

}
