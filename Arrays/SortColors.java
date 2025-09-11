// Sort 0s 1s and 2s
// Dutch national flag problem

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args){
        int[] arr = {0, 1, 2, 0, 1, 2};
        sortArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    // BY using Arrays.sort  |  TC : O(n log(n)) --> sorting algo
    static void sortArr(int[] arr){
        Arrays.sort(arr);
    }
}
