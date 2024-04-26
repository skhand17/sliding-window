package src.practice;

public class FindMinSubArray {

    public static void main(String[] args) {
        int[] num = new int[]{3, 4, 1, 1, 6};
        int S = 8;

        int minSubArray = findMinSubArray(S, num);
        System.out.println(minSubArray);


    }



    public static int findMinSubArray(int S, int[] arr) {

        int minimumSizeOfSubArray = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for(int end = 0; end < arr.length; end++) {

            sum += arr[end];

            while(sum >= S){
                minimumSizeOfSubArray = Math.min(minimumSizeOfSubArray, end - start + 1);
                sum -= arr[start++];
            }

        }
        return minimumSizeOfSubArray;

    }
}
