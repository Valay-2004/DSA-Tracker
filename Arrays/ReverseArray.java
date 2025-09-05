// Solution for Reversing an Array

public class ReverseArray {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void reverseArray(int[] arr){
        // It's basically a two pointer approach
        // we are starting from both the direction
        // in the same loop
        int left = 0; // starting index
        int right = arr.length - 1; // last index

        // run loop till left = right
        while(left < right){
            // swap the left with the right
            // the middle element will be the same
            // in the reverse array so we just have
            // to iterate till half of the array
            int temp = arr[left]; // a temp element to store the left index value
            arr[left] = arr[right];
            arr[right] = temp;

            // increment left
            left++;
            // decrement right
            right--;
        }
    }
}