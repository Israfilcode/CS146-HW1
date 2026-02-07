import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * JUnit test class for MergeSortedArrays
 * Tests various scenarios including edge cases
 * 
 * @author Yisilayin Silapei
 * @date February 6, 2026
 */
public class MergeSortedArraysTest {
    
    /**
     * Test merging two regular sorted arrays of equal length
     * Expected: Elements should be in ascending order
     */
    @Test
    public void testMergeEqualLengthArrays() {
        // Arrange: Set up test data
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        
        // Act: Call the method being tested
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert: Verify the result matches expectations
        assertArrayEquals("Merged array should contain all elements in sorted order", 
                         expected, result);
    }
    
    /**
     * Test merging arrays with different lengths
     * First array is shorter than second
     */
    @Test
    public void testMergeDifferentLengthArrays() {
        // Arrange
        int[] arr1 = {1, 5, 9};
        int[] arr2 = {2, 3, 4, 6, 7, 8};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("Should handle arrays of different lengths", 
                         expected, result);
    }
    
    /**
     * Test merging when first array is empty
     * Should return the second array
     */
    @Test
    public void testMergeFirstArrayEmpty() {
        // Arrange
        int[] arr1 = {};
        int[] arr2 = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("Empty first array should return second array", 
                         expected, result);
    }
    
    /**
     * Test merging when second array is empty
     * Should return the first array
     */
    @Test
    public void testMergeSecondArrayEmpty() {
        // Arrange
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {};
        int[] expected = {1, 2, 3, 4};
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("Empty second array should return first array", 
                         expected, result);
    }
    
    /**
     * Test merging when both arrays are empty
     * Should return an empty array
     */
    @Test
    public void testMergeBothArraysEmpty() {
        // Arrange
        int[] arr1 = {};
        int[] arr2 = {};
        int[] expected = {};
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("Two empty arrays should return empty array", 
                         expected, result);
    }
    
    /**
     * Test merging arrays with duplicate elements
     * Duplicates should be preserved in the result
     */
    @Test
    public void testMergeWithDuplicates() {
        // Arrange
        int[] arr1 = {1, 3, 3, 5};
        int[] arr2 = {2, 3, 4, 5};
        int[] expected = {1, 2, 3, 3, 3, 4, 5, 5};
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("Duplicates should be preserved", 
                         expected, result);
    }
    
    /**
     * Test merging arrays with negative numbers
     * Should handle negative values correctly
     */
    @Test
    public void testMergeWithNegativeNumbers() {
        // Arrange
        int[] arr1 = {-5, -3, -1, 0};
        int[] arr2 = {-4, -2, 1, 2};
        int[] expected = {-5, -4, -3, -2, -1, 0, 1, 2};
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("Should handle negative numbers correctly", 
                         expected, result);
    }
    
    /**
     * Test merging when all elements of first array are smaller
     * Result should be arr1 followed by arr2
     */
    @Test
    public void testMergeFirstArrayAllSmaller() {
        // Arrange
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("First array all smaller should be first in result", 
                         expected, result);
    }
    
    /**
     * Test merging when all elements of second array are smaller
     * Result should be arr2 followed by arr1
     */
    @Test
    public void testMergeSecondArrayAllSmaller() {
        // Arrange
        int[] arr1 = {7, 8, 9};
        int[] arr2 = {1, 2, 3};
        int[] expected = {1, 2, 3, 7, 8, 9};
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("Second array all smaller should be first in result", 
                         expected, result);
    }
    
    /**
     * Test merging single-element arrays
     */
    @Test
    public void testMergeSingleElementArrays() {
        // Arrange
        int[] arr1 = {5};
        int[] arr2 = {3};
        int[] expected = {3, 5};
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("Should merge single-element arrays correctly", 
                         expected, result);
    }
    
    /**
     * Test null handling: first array is null
     */
    @Test
    public void testMergeFirstArrayNull() {
        // Arrange
        int[] arr1 = null;
        int[] arr2 = {1, 2, 3};
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("Null first array should return second array", 
                         arr2, result);
    }
    
    /**
     * Test null handling: second array is null
     */
    @Test
    public void testMergeSecondArrayNull() {
        // Arrange
        int[] arr1 = {1, 2, 3};
        int[] arr2 = null;
        
        // Act
        int[] result = MergeSortedArrays.merge(arr1, arr2);
        
        // Assert
        assertArrayEquals("Null second array should return first array", 
                         arr1, result);
    }
}
