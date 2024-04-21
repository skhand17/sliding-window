package src.hard;


import java.util.HashMap;
import java.util.Map;

/*Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

Example 1:

Input: str="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
Example 2:

Input: str="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
Example 3:

Input: str="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".

*/
public class Longest_Substring_With_Same_Letters_After_Replacement {

    public static void main(String[] args) {

        String str = "aabccbb";
        int k = 2;

        int longestLength = findLength(str, k);
        System.out.println(longestLength);

    }

    public static int findLength(String str, int k) {

        int maxLength = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;
        int maxFreCountCurrently = 0;

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd ++) {

            char currentCharacter = str.charAt(windowEnd);
            freqMap.put(currentCharacter, freqMap.getOrDefault(currentCharacter, 0) + 1);
            maxFreCountCurrently = Math.max(maxFreCountCurrently, freqMap.get(currentCharacter));
            if(windowEnd - windowStart + 1 > maxFreCountCurrently + k) {
            /*
            * Need to think on this condition */
                freqMap.put(str.charAt(windowStart), freqMap.get(str.charAt(windowStart))-1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }

        return maxLength;
    }
}
