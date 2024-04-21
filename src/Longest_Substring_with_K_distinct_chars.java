package src;

import java.util.HashMap;

public class Longest_Substring_with_K_distinct_chars {

    public static void main(String[] args) {
        String str = "cbbebi";
        int k = 3;
        int longestSubstring = findLength(str, k);
        System.out.println(longestSubstring);
    }

    public static int findLength(String str, int k){
        /*
        *
        * Write your logic and code here
        *
        * */

        int windowStart = 0;
        int maxLength = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        /*
        *
        * Iterate through the characters of the string using windowEndPointer
        *
        * */

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd ++) {

            /*
            * Extract character at index windowEnd
            * */

            char windowEndChar = str.charAt(windowEnd);

            frequencyMap.put(windowEndChar, frequencyMap.getOrDefault(windowEndChar , 0) + 1);

            if(frequencyMap.size() > k) {
                /*
                * Once the size of a hashMap has increased than the allowed distinct
                * characters which is k, I need to shrink my window by decrementing the character
                * frequency count from the hashMap of the character where windowStart index is pointing at
                * Along with that if frequency of that character has become 0 then I should remove it from my hashMap
                * and windowStart index should also be incremented by one
                * */
                char windowStartChar = str.charAt(windowStart);
                frequencyMap.put(windowStartChar, frequencyMap.get(windowStartChar) - 1);

                if(frequencyMap.get(windowStartChar) == 0)
                    frequencyMap.remove(windowStartChar);

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }

        return maxLength;
    }
}
