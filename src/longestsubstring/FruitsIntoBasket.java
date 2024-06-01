package src.longestsubstring;

import java.util.HashMap;

public class FruitsIntoBasket {
    public static void main(String[] args) {

        char[] fruits = new char[]{'A', 'B', 'C', 'B', 'B', 'C'};

        int maxFruits = maxFruitsFromTrees(fruits);
        System.out.println(maxFruits);
    }

    public static int maxFruitsFromTrees(char[] fruits) {

        int windowStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int length = fruits.length;
        int maxLength = 0;
        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            map.put(fruits[windowEnd], map.getOrDefault(fruits[windowEnd], 0) + 1);

            if (map.size() > 2) {
                map.put(fruits[windowStart], map.get(fruits[windowStart]) - 1);
                if (map.get(fruits[windowStart]) == 0)
                    map.remove(fruits[windowStart]);
                windowStart++;
            }

            int len = windowEnd - windowStart + 1;
            maxLength = Math.max(maxLength, len);

        }
        return maxLength;
    }
}
