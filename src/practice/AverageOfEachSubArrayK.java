package src.practice;

import java.util.Arrays;

public class AverageOfEachSubArrayK {

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
        int k = 5;
        double []average = findAverage(arr, k);
        Arrays.stream(average).forEach(System.out::println);

    }

    private static double[] findAverage(int[] arr, int k) {
        double [] averageArr = new double[arr.length - k + 1];

        int windowSum = 0;
        int windowStart = 0;

        for(int windowEnd=0; windowEnd<arr.length; windowEnd++){
            windowSum += arr[windowEnd];

            /*
            * If we are crossing the window
            *
            * */
            if(windowEnd >= k-1){
                double average = windowSum/k;
                averageArr[windowStart] = average;
                windowSum -= arr[windowStart++];
            }
        }
        return averageArr;
    }
}
