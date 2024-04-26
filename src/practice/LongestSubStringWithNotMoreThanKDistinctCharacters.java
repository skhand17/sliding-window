package src.practice;

import java.util.HashMap;

public class LongestSubStringWithNotMoreThanKDistinctCharacters {

    public static void main(String[] args) {

        String str = "araaci";
        int k = 2;

        int longestLength = findLength(str, k);
        System.out.println(longestLength);
    }

    public static int findLength(String str, int k) {

        HashMap<Character, Integer> freqMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;

        int windowStart = 0;


        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {


            char currentCharacter = str.charAt(windowEnd);

            freqMap.put(currentCharacter, freqMap.getOrDefault(currentCharacter, 0) + 1);

            if (freqMap.size() > k) {

                char charAtStart = str.charAt(windowStart);
                freqMap.put(charAtStart, freqMap.get(charAtStart) - 1);

                if (freqMap.get(charAtStart) == 0)
                    freqMap.remove(charAtStart);

                windowStart++;
            }


            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }

        return maxLength;
    }
}
