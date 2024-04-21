package src;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public static void main(String[] args) {

        char [] arr = new char[] {'A', 'B', 'C', 'B', 'B', 'C'};
        int length = findLength(arr);
        System.out.println(length);
    }

    public static int findLength(char[] arr) {

        int maxLength = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        int windowStart = 0;

        for(int windowEnd = 0 ; windowEnd < arr.length; windowEnd++){

            /*
            Extract character from windowEnd
            *
            */

            freqMap.put(arr[windowEnd], freqMap.getOrDefault(arr[windowEnd], 0) + 1);

            while(freqMap.size() > 2) {
                freqMap.put(arr[windowStart], freqMap.get(arr[windowStart]) - 1);

                if(freqMap.get(arr[windowStart]) == 0)
                    freqMap.remove(arr[windowStart]);

                windowStart++;

            }

            maxLength = Math.max(maxLength, windowEnd - windowStart +1);

        }
        return maxLength;
    }
}
