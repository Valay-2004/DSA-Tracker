import java.util.Arrays;

// Moving all the negatives to the front side of the array
public class MoveNegatives {
    public static void main(String[] args){
        int[] arr = {-1,-2,3,4,5,-6,-7,8,9,0};
        System.out.println(Arrays.toString(usingSort(arr)));
        System.out.println(Arrays.toString(quickSortMoveNeg(arr)));
        System.out.println(Arrays.toString(twoPointMove(arr)));
    }

    // Using Arrays.sort sort the array and return it
    // Time : O(nlog(n)) , Space : O(1)
    public static int[] usingSort(int[] arr){
        Arrays.sort(arr);
        return arr;
    }

    // Using Quick Sort Partition   |   Time : O(n) , Space : O(1)
    public static int[] quickSortMoveNeg(int[] arr){
        int n = arr.length;
        int j = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] < 0){
                // swapping
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }

    // By using Two pointer method
    // Time : O(n), Space : O(1)
    public static int[] twoPointMove(int[] arr){
        int left = 0; int right = arr.length - 1;
        while(left < right){
            // increment left while arr[left]
            // is negative
            while(left < right && arr[left] < 0){
                left++;
            }

            // decrement right while arr[right]
            // is positive
            while(right > left && arr[right] > 0){
                right--;
            }

            // swap the elements
            if(right > left){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return arr;
    }
}