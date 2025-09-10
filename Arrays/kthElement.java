import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class kthElement {

    public static void main(String[] args){
        int[] arr = {3,4,5,2,1,6};
        int k = 4;
        System.out.println(sortKth(arr, k));
        System.out.println(kthLargest(arr, k));
    }

    // Easiest solution using sort
    // Time : O(nlog(n))
    public static int sortKth(int[] arr, int k){
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    // Create a method to return quick Select
    // Time : O(n), worst case O(n^2)
    public static int kthLargest(int[] arr, int k){
        // Create a list to store the arr
        // as we will be doing operation downsizing and all
        // so the list is efficient than arr
        List<Integer> result = new ArrayList<>();
        for(int i : arr){
            result.add(i);
        }

        // work with the quickselect
        return quickSelectRec(result, k);
    }

    private static int quickSelectRec(List<Integer> result, int k) {
        // return the first element if size is 1
        if (result.size() == 1) return result.getFirst();
        // create a pivot which will be assigned a random
        // value from the list
        int pivotIdx = new Random().nextInt(result.size());
        // assign the value as pivot
        int pivot = result.get(pivotIdx);

        // create three lists to work as a partition
        // | lower | equal | greater |
        List<Integer> lower = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        // check each value in result
        for (int i : result) {
            // add 'i' in greater if
            // 'i' is greater than pivot
            if (i > pivot) {
                greater.add(i);
            }
            // add 'i' in lower if
            // 'i' is lower than pivot
            else if (i < pivot) {
                lower.add(i);
            }
            // else if both not the case
            // then that means it will go
            // in equal list
            else {
                equal.add(i);
            }
        }

        // now if the value of k is less than
        // or equal to the size of the greater list
        // recurse this method with the greater list
        // and k
        if (k <= greater.size()) {
            return quickSelectRec(greater, k);
        }
        // if the greater + equal list has lower value
        // than k then we must recurse with the lower list
        // and reducing the k size as greater and equal should be removed
        if (greater.size() + equal.size() < k) {
            return quickSelectRec(lower, k - greater.size() - equal.size());
        }

        // at end return the pivot
        // which will be ours kth the largest element
        return pivot;
    }
}
