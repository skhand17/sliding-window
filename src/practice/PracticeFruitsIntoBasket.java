package src.practice;

import java.util.HashMap;

public class PracticeFruitsIntoBasket {

    public static void main(String[] args) {

        char[] arr = new char[]{'A', 'B', 'C', 'B', 'B', 'C'};

        int maxFruits = findLength(arr);
        System.out.println(maxFruits);
    }

    public static int findLength(char[] arr) {

        int maxLength = Integer.MIN_VALUE;

        int start = 0;

        HashMap<Character, Integer> basketMap = new HashMap<>();


        for(int end=0; end< arr.length; end++){


            basketMap.put(arr[end], basketMap.getOrDefault(arr[end], 0) + 1);


            while (basketMap.size() > 2) {

                basketMap.put(arr[start], basketMap.get(arr[start]) - 1);

                if(basketMap.get(arr[start]) == 0)
                    basketMap.remove(arr[start]);

                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
