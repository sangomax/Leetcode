public class ImplementstrStr28 {

    public int strStr(String haystack, String needle) {

        if(needle.length() > haystack.length()) { return -1; }

        int startIndex = 0;
        int needleIndex = 0;
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        if(!needle.isEmpty()) {
            for (int i = 0; i < haystackArray.length - needle.length() + 1; i++) {
                if(haystackArray[i] == needleArray[needleIndex]) {
                    if(needle.length() > 1) {
                        startIndex = i + 1;
                        needleIndex++;
                        do {
                            if (haystackArray[startIndex] == needleArray[needleIndex]) {
                                startIndex++;
                                needleIndex++;
                            } else {
                                needleIndex = 0;
                                break;
                            }
                        } while (needleIndex < needle.length());
                        if (needle.length() == needleIndex) {
                            return i;
                        }
                    } else {
                        return i;
                    }
                }
            }
        } else {
            return 0;
        }

        return -1;
    }


    public static void main(String[] args) {
        ImplementstrStr28 obj = new ImplementstrStr28();
        System.out.println(obj.strStr("a", "a"));
    }
}
