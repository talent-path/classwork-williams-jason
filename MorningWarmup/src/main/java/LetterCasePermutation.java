import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isLetter;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class LetterCasePermutation {
    public static void main(String[] args) {
        String test = "a1b2";

        permute(test,0);
    }

    private static List<String> permute(String s,int i) {
        List<String> perms = new ArrayList<>();
        perms.add(s);
            if (isLetter(s.charAt(i))) {
                s = toUpperCase(s.charAt(i));
                permute(s.substring(i),i+1);
                s = toLowerCase(s.charAt(i+1));
            }
        return perms;
    }

}


//    public static String swap(String a, int i, int j) {
//        char temp;
//        char[] charArray = a.toCharArray();
//        temp = charArray[i];
//        charArray[i] = charArray[j];
//        charArray[j] = temp;
//        String ans = String.valueOf(charArray);
//        return ans;
//    }


