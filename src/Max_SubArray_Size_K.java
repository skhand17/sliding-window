package src;

public class Max_SubArray_Size_K {

    public static void main(String[] args) {

        int [] arr = new int[] {2, 1, 5, 1, 3, 2};
        int k = 3;

        int maximumSum = findMaxSumSubArray(arr, 3);
        System.out.println(maximumSum);
    }

    public static int findMaxSumSubArray(int arr[], int k){

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){

            currentSum += arr[windowEnd];

            /*
            * I have reached a window of size equals to k
            * */
            if(windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= arr[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }
}
