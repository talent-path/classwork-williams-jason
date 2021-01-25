public class Test {
    public static void main(String[] args) {
        String s = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int biggestLength = 1;
        int length = 0;
        String a;
        String b;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j > i; j--) {
                a = s.substring(i, i + 1);
                b = s.substring(j-1, j);
                if (!a.equals(b)) {
                    length++;
                } else break;
            }
            if (length > biggestLength)
                biggestLength = length;
            length = 0;
        }

        return biggestLength;
    }
}

