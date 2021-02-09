import java.util.HashMap;
import java.util.Map;

public class MinWindowFinder {

    public static void main(String[] args) {
        String test1 = "fla";
        String test2 = "asdflabanc";


        System.out.println(minWindow(test2, test1));

    }

    public static String minWindow(String s, String t) {


        Map<String,Integer> checkingCharacters = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            checkingCharacters.put(t.substring(i,i+1),i);
        }



        for (int i = 0; i <= s.length(); i++) {
            Map<String,Integer>  currentWindow = new HashMap<>();
            for (int j = i; j <= s.length(); j++) {
                if(currentWindow.containsKey(checkingCharacters.keySet())){
                    
                }
            }
        }
        return "cda";
    }
}
