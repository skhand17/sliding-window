package src.longestsubstring;

import java.util.HashMap;

public class MinWinSubPractice {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String substring = minWindow(s, t);
        System.out.println(substring);
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int lengthOfS = s.length();
//        int lengthOfT = t.length();

        int left = 0;
        int right = 0;
        int minLength = lengthOfS + 1;
        int substrIndex = -1;
        int count = 0;

        while (right < lengthOfS) {
            char atIndexRight = s.charAt(right);
            if (map.containsKey(atIndexRight)) {
                map.put(atIndexRight, map.get(atIndexRight) - 1);
                if (map.get(atIndexRight) == 0) {
                    count++;
                }
            }

            while (count == map.size()) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    substrIndex = left;
                }
                char deleted = s.charAt(left++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) {
                        count--;
                    }
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
            right = right + 1;
        }
        return minLength > lengthOfS ? "" : s.substring(substrIndex, substrIndex + minLength);
    }
}
