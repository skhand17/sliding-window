package src.practice;

import java.util.HashMap;

public class LongestSubstringwithSameLettersafterReplacement {

    public static void main(String[] args) {

        String str = "aabccbb";
        int k = 2;

        int longestLengthWithSameCharacters = findLength(str, k);
        System.out.println(longestLengthWithSameCharacters);

    }

    public static int findLength(String str, int k) {

        int start = 0;
        int longestLengthWithSameCharacters = 0;

        HashMap<Character, Integer> freqMap = new HashMap<>();

        int maxFreqInAGivenWindow = 0;


        for(int end = 0; end < str.length(); end++) {

            char charAtEnd = str.charAt(end);
            freqMap.put(charAtEnd, freqMap.getOrDefault(charAtEnd , 0)  + 1);
            maxFreqInAGivenWindow = Math.max(maxFreqInAGivenWindow,freqMap.get(charAtEnd));


            if(end - start + 1 > maxFreqInAGivenWindow + k) {
                char charAtStart = str.charAt(start);
                freqMap.put(charAtStart , freqMap.getOrDefault(charAtStart , 0) + 1);
                if(freqMap.get(charAtStart) == 0)
                    freqMap.remove(charAtStart);
                start++;
            }
            longestLengthWithSameCharacters = Math.max(longestLengthWithSameCharacters, end - start + 1);
        }
        return longestLengthWithSameCharacters;

    }
}
