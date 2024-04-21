package src;

public class Sliding_Window_Basic {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;

        double [] averages = findAverages(arr, k);
        for(double a : averages){
            System.out.print(a + " ");
        }
    }

    public static double[] findAverages(int[] arr, int k){

        double [] averages = new double[arr.length - k + 1];
        int windowStart = 0;
        double windowSum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];


            if(windowEnd >= k - 1){
                averages[windowStart] = windowSum/k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return averages;
    }
}
