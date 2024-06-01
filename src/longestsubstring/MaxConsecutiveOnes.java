package src.longestsubstring;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 2;
        int length = maxLengthConsecutiveOnes(arr, k);
        System.out.println(length);
    }

    public static int maxLengthConsecutiveOnes(int[] arr, int k) {

        int left = 0;
        int right = 0;
        int n = arr.length;
        int maxLength = 0;
        int countZeros = 0;

        while(right < n) {

            if(arr[right] == 0){
                countZeros++;
            }
            while (countZeros > k){
                if(arr[left] == 0){
                    countZeros--;
                }
                left++;
            }

            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
            right++;
        }
        return maxLength;
    }

}
