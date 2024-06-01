package src.longestsubstring;

import java.util.HashMap;

public class NumberOfSubstringContainingAll3Characters {

    public static void main(String[] args) {
        String s = "abcabc";

        int numSubstrings = countNumberofSubstrings(s);
        System.out.println(numSubstrings);
    }

    public static int countNumberofSubstrings(String s) {

        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int len = s.length();

        while(right < len){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0 ) + 1);
            while(map.size() == 3){
                count = count + (1 + (len - left) - (right -left + 1));
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0)
                    map.remove(s.charAt(left));
                left++;
            }
            right++;
        }
        return count;
    }
}
