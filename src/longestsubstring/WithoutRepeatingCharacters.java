package src.longestsubstring;

import java.util.HashMap;

public class WithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "cadbzabcd";
        int longest = findLongestSubstring(s);
        System.out.println(longest);
    }

    public static int findLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map.containsKey(ch))
                left = Math.max(map.get(ch) + 1, left);
            map.put(ch, right);
            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
            right++;
        }
        return maxLength;
    }
}
