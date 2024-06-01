package src.longestsubstring;

import java.util.HashMap;

public class PermuationsString {

    public static void main(String[] args) {
        String input = "odicf";
        String pattern = "dc";

        boolean isPresent = isPatternPresent(input, pattern);
        System.out.println(isPresent);
    }

    private static boolean isPatternPresent(String input, String pattern) {

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char ch : pattern.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,  0) + 1);
        }

        int left = 0;
        int right = 0;
        int lengthInputStr = input.length();
        int matchedCount = 0;

        while (right < lengthInputStr) {
            char charAtRightIdx = input.charAt(right);
            if(freqMap.containsKey(charAtRightIdx)){
                freqMap.put(charAtRightIdx, freqMap.get(charAtRightIdx) - 1);
                if(freqMap.get(charAtRightIdx) == 0){
                    matchedCount++;
                }
            }
            if(matchedCount == freqMap.size())
                return true;

            if(right >= pattern.length() - 1) {
                char charAtLeftIdx = input.charAt(left++);
                if (freqMap.containsKey(charAtLeftIdx)) {
                    if (freqMap.get(charAtLeftIdx) == 0) {
                        matchedCount--;
                    }
                    freqMap.put(charAtLeftIdx, freqMap.get(charAtLeftIdx) + 1);
                }
            }
            right++;
        }
        return false;
    }
}
