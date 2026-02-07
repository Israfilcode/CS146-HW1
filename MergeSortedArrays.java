/**
 * MergeSortedArrays class provides functionality to merge two sorted arrays
 * into a single sorted array.
 * 
 * @author Yisilayin Silapei
 * @date February 6, 2026
 */
public class MergeSortedArrays {
    
    /**
     * Merges two sorted arrays into one sorted array.
     * 
     * Time Complexity: O(n + m) where n and m are lengths of the two arrays
     * Space Complexity: O(n + m) for the result array
     * 
     * @param arr1 First sorted array
     * @param arr2 Second sorted array
     * @return A new sorted array containing all elements from both input arrays
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        // Handle edge cases: if either array is null, return the other one
        if (arr1 == null) return arr2;
        if (arr2 == null) return arr1;
        
        // Get lengths of both arrays
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        // Create result array with combined length
        int[] result = new int[n1 + n2];
        
        // Initialize three pointers:
        // i - pointer for arr1
        // j - pointer for arr2
        // k - pointer for result array
        int i = 0, j = 0, k = 0;
        
        // Main merge loop: compare elements from both arrays
        // and add the smaller one to result
        while (i < n1 && j < n2) {
            // If current element in arr1 is smaller or equal,
            // add it to result and move arr1 pointer forward
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } 
            // Otherwise, current element in arr2 is smaller,
            // add it to result and move arr2 pointer forward
            else {
                result[k] = arr2[j];
                j++;
            }
            // Move result array pointer forward
            k++;
        }
        
        // Copy remaining elements from arr1 (if any)
        // This happens when arr2 is exhausted but arr1 still has elements
        while (i < n1) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        
        // Copy remaining elements from arr2 (if any)
        // This happens when arr1 is exhausted but arr2 still has elements
        while (j < n2) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        
        return result;
    }
    
    /**
     * Helper method to print an array (useful for testing/debugging)
     * 
     * @param arr Array to print
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Main method for quick manual testing
     */
    public static void main(String[] args) {
        // Test case 1: Regular merge
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        
        System.out.println("Array 1:");
        printArray(arr1);
        System.out.println("Array 2:");
        printArray(arr2);
        System.out.println("Merged Array:");
        printArray(merge(arr1, arr2));
        
        System.out.println("\n---");
        
        // Test case 2: Arrays with different lengths
        int[] arr3 = {1, 5, 9};
        int[] arr4 = {2, 3, 4, 6, 7, 8};
        
        System.out.println("Array 3:");
        printArray(arr3);
        System.out.println("Array 4:");
        printArray(arr4);
        System.out.println("Merged Array:");
        printArray(merge(arr3, arr4));
    }
}
