// Sort 0s 1s and 2s
// Dutch national flag problem

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args){
        int[] arr = {0, 1, 2, 0, 1, 2};
//        sortArr(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(countAndSort(arr)));
        System.out.println(Arrays.toString(sort012(arr)));
    }

    // BY using Arrays.sort  |  TC : O(n log(n)) --> sorting algo
    static void sortArr(int[] arr){
        Arrays.sort(arr);
    }

    // By counting the number of 0s, 1s, 2s
    // and then change the array accordingly to
    // the elements count
    // TC --> can be O(n) as O(n) + O(n) ~ O(2xn)
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

    // But again there exists a proper approach and solution for the given problem
    // TC --> O(n)
    static int[] sort012(int[] arr){
        int n = arr.length;
        // initialize three pointers:
        // 1. Boundary of 0s
        int lo = 0;
        // 2. Boundary of 2s
        int hi = n - 1;
        // mid-value (middle array will be 1s)
        int mid = 0;

        // Loop till mid <= high
        while(mid <= hi){
            if(arr[mid] == 0){
                // current is 0: swap with lo
                // and move both the pointer forward
                int temp = arr[lo];
                arr[lo++] = arr[mid];
                arr[mid++] = temp;
            }
            else if(arr[mid] == 1){
                // if middle is 1 just increment middle
                // as we want 1s to be in the middle
                mid++;
            }
            else{
                // current is 2 : now swap mid with hi
                // as 2 should be in the last
                // do not increment the mid as we need to recheck the swapped values
                // and decrement the high
                int temp = arr[mid];
                // if we try to increment mid here our swapped elements
                // will stay their without other rechecking
                // thus resulting in 2 or 0 in the middle sub array
                arr[mid] = arr[hi];
                arr[hi--] = temp;
            }
        }
        return arr;
    }
}
