public class StringIntegerAtoi8 {

    public int myAtoi(String s) {

        String result = "";

        for(int i = 0; i < s.length(); i++) {

            boolean flag = false;
            switch (s.substring(i,i+1)) {
                case "-": if (result.length() == 0) { result += s.substring(i,i+1); } else { flag = true; } break;
                case "+": if (result.length() == 0) { result += s.substring(i,i+1); } else { flag = true; } break;
                case " ": if (result.length() != 0) { flag = true; } break;
                case "1","2","3","4","5","6","7","8","9","0": result += s.substring(i,i+1); break;
                default:
                    flag = true;
            }

            if(flag) {
                break;
            }
        }

        try {
            return (result.length() > 0 && (!result.equals("-") && !result.equals("+"))) ? Integer.valueOf(result) : 0;
        } catch (NumberFormatException e) {
            if(result.substring(0,1).equals("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }


    }

    public static void main(String[] args) {
        StringIntegerAtoi8 obj = new StringIntegerAtoi8();

        int r = obj.myAtoi("   +0 123");
        System.out.println(r);
    }
}
