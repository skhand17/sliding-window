package src.hard;

/*Given a string and a pattern, find out if the string contains any permutation of the pattern.

        Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

        abc
        acb
        bac
        bca
        cab
        cba
        If a string has ‘n’ distinct characters, it will have n! permutations.

        Example 1:

        Input: str="oidbcaf", pattern="ABC"
        Output: true
        Explanation: The string contains "bca" which is a permutation of the given pattern.
        Example 2:

        Input: str="odicf", pattern="dc"
        Output: false
        Explanation: No permutation of the pattern is present in the given string as a substring.
        Example 3:

        Input: str="bcdxabcdy", pattern="bcdyabcdx"
        Output: true
        Explanation: Both the string and the pattern are a permutation of each other.
        Example 4:

        Input: str="aaacb", pattern="abc"
        Output: true
        Explanation: The string contains "acb" which is a permutation of the given pattern.
        Constraints:

        1 <= str.length, pat.length <= 10<sup>4</sup>
        str and pat consist of lowercase English letters.*/

import java.util.HashMap;
import java.util.Map;

public class Permutations_in_a_string {

    public static void main(String[] args) {

        String str = "oidbcaf";
        String pattern = "abc";

        boolean isMatched = findPermutation(str, pattern);
        System.out.println(isMatched);

    }

    public static boolean findPermutation(String str, String pattern) {


        int windowStart = 0;
        Map<Character, Integer> freqMapPattern = new HashMap<>();
        int matched = 0;

        for(int i=0; i<pattern.length(); i++){
            freqMapPattern.put(pattern.charAt(i), freqMapPattern.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            if(freqMapPattern.containsKey(str.charAt(windowEnd))) {
                freqMapPattern.put(str.charAt(windowEnd), freqMapPattern.get(str.charAt(windowEnd)) - 1);

                if(freqMapPattern.get(str.charAt(windowEnd)) == 0)
                    matched++;
            }

            if(matched == freqMapPattern.size()){
                return  true;
            }

            if(windowEnd >= pattern.length() - 1) {

                char windowStartLeft = str.charAt(windowStart++);

                if(freqMapPattern.containsKey(windowStartLeft)){
                    if(freqMapPattern.get(windowStartLeft) == 0)
                        matched--;

                    freqMapPattern.put(windowStartLeft, freqMapPattern.get(windowStartLeft) + 1);
                }
            }
        }
        return false;
    }
}
