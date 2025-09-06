import java.util.Arrays;

// Finding Minimum and Maximum
public class MaxMin {
    public static void main(String[] args){
        int[] arr = {0,3,2,5,6,7};
        maxMin(arr);
        System.out.println("------------");
        minMaxSorted(arr);
    }

    // Iteration approach   |   Time: O(n)
    public static void maxMin(int[] arr){
        // n -> length of the array
        int n = arr.length;

        // return nothing when the arr is empty
        // not necessary just a case
        if(n == 0){
            return;
        }

        // get the first index of the array in min and max
        int max = arr[0];
        int min = arr[0];

        // now loop through the array and compare
        for (int j : arr) { // enhanced loop as we are going for each element
            // if max -> first value is lower than the value at current index
            // change max to j
            if (max < j) {
                max = j;
            }
            // same here just if the min is greater than j
            // change min to j
            if (min > j) {
                min = j;
            }
        }
        System.out.println("Minimum element :" + min);
        System.out.println("Maximum element :" + max);
    }

    // Built-in sorting method   |  Time: O(n*log(n))
    public static void minMaxSorted(int[] arr){
        // This is the simplest way
        // sort the array using built in method
        Arrays.sort(arr);
        // then we get the first element as the smallest
        // and the last element as the largest
        System.out.println("Minimum element :" + arr[0]);
        System.out.println("Maximum element :" + arr[arr.length - 1]);
    }
}
