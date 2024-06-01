package src.longestsubstring;

import java.util.HashMap;

public class RepeatingCharacterReplacement {

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        String s2 = "ABAB";
        int k2 = 2;

        int longest = characterReplacement(s2, k2);
        System.out.println(longest);
    }

    public static int characterReplacement(String s, int k) {

        int windowStart = 0;
        int maxFreCounter = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int windowEnd =0; windowEnd < s.length(); windowEnd++) {

            char characterAtWindowEnd = s.charAt(windowEnd);
            map.put(characterAtWindowEnd, map.getOrDefault(characterAtWindowEnd, 0) + 1);
            maxFreCounter = Math.max(maxFreCounter, map.get(characterAtWindowEnd));

            if(windowEnd - windowStart + 1 > maxFreCounter + k) {
                char characterAtWindowStart = s.charAt(windowStart);
                map.put(characterAtWindowStart, map.get(characterAtWindowStart) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
