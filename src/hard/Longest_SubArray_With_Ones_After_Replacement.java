package src.hard;

import java.util.HashMap;
import java.util.Map;

/*Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

Example 1:

Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
Example 2:

Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
Constraints:

1 <= arr.length <=
arr[i] is either 0 or 1.
0 <= k <= nums.length*/
public class Longest_SubArray_With_Ones_After_Replacement {

    public static void main(String[] args) {
        int [] arr = new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 3;
        int maxLength = findLength(arr , k);
        System.out.println(maxLength);
    }

    public static int findLength(int [] arr, int k) {

        int windowStart = 0;
        int maxCount = 0;
        int maxLength = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd ++) {

            if (arr[windowEnd] == 1)
                maxCount++;

            if (windowEnd - windowStart + 1 > k + maxCount) {
                if (arr[windowStart] == 1)
                    maxCount--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;
    }


}
