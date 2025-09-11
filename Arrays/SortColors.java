// Sort 0s 1s and 2s
// Dutch national flag problem

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args){
        int[] arr = {0, 1, 2, 0, 1, 2};
//        sortArr(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(countAndSort(arr)));
    }

    // BY using Arrays.sort  |  TC : O(n log(n)) --> sorting algo
    static void sortArr(int[] arr){
        Arrays.sort(arr);
    }

    // By counting the number of 0s, 1s, 2s
    // and then change the array accordingly to
    // the elements count
    static int[] countAndSort(int[] arr){
        int c0 = 0; int c1= 0; int c2 = 0;
        //loop to count the numbers
        for (int j : arr) {
            if (j == 0) {
                c0 += 1;
            }
            if (j == 1) {
                c1 += 1;
            }
            if (j == 2) {
                c2 += 1;
            }
        }

        // let the index 0
        int idx = 0;

        // now one by one replace the original array
        // with the elements we want
        // for first traverse
        for(int i = 0; i < c0; i++){
            arr[idx++] = 0;
        }
        // for second traverse
        for(int i = 0; i < c1; i++){
            arr[idx++] = 1;
        }
        // for third traverse
        for(int i = 0; i < c2; i++){
            arr[idx++] = 2;
        }

        // return the array
        return  arr;
    }
}
