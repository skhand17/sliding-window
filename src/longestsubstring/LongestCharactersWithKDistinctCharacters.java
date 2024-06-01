package src.longestsubstring;

import java.util.HashMap;

public class LongestCharactersWithKDistinctCharacters {

    public static void main(String[] args) {

        String s = "araaci";
        int k = 2;

        int lengthLongest = lengthOfLongestSubstring(s, k);
        System.out.println(lengthLongest);
    }

    public static int lengthOfLongestSubstring(String s, int k) {

        int left = 0;
        int right = 0;
        int stringLength = s.length();
        int maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < stringLength) {

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0)
                    map.remove(leftChar);
                left++;
            }
            int currentLength = right -left + 1;
            maxLength = Math.max(maxLength, currentLength);
            right++;
        }

        return maxLength;
    }
}
