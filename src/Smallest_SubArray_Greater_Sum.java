package src;

public class Smallest_SubArray_Greater_Sum {
    public static void main(String[] args) {

//        int [] arr = new int[]{2, 1, 5, 2, 3, 2};
//        int S = 7;

//        int [] arr = new int[]{2, 1, 5, 2, 8};
//        int S = 7;
//
//        int [] arr = new int[]{3, 4, 1, 1, 6};
//        int S = 8;

        int [] arr = new int[]{1, 1, 1};
        int S = 10;
        int minimumWindowSize = findMinSubArray(S, arr);
        System.out.println(minimumWindowSize);
    }

    public static int findMinSubArray(int S, int[] arr) {
        int currentSum = 0;
        int windowStart = 0;
        int minimumWindowSize = Integer.MAX_VALUE;
        int currentWindowSize = 0;

        for(int windowEnd = 0;  windowEnd < arr.length; windowEnd++) {
            currentSum += arr[windowEnd];

            while(currentSum >= S){
                currentWindowSize = windowEnd - windowStart + 1;
                minimumWindowSize = Math.min(minimumWindowSize, currentWindowSize);
                currentSum -= arr[windowStart];
                windowStart++;
            }

        }
        return minimumWindowSize != Integer.MAX_VALUE ? minimumWindowSize : 0;
    }
}
