package src.longestsubstring;

import org.w3c.dom.ls.LSOutput;

public class BinarySubArraysWithSum {

    public static void main(String[] args) {


        int[] arr = new int[]{1, 0, 1, 0, 1};
        int goal = 2;

        int length = f(arr, goal) - f(arr, goal - 1);
        System.out.println(length);
    }

    private static int f(int[] arr, int goal) {
        if (goal < 0)
            return 0;

        int left = 0;
        int right = 0;
        int n = arr.length;
        int sum = 0;
        int count = 0;

        while (right < n) {
            sum += arr[right];

            while (sum > goal){
                sum -= arr[left];
                left++;
            }
            count += right -left +1;
            right++;
        }
        return count;
    }
}
