package algorithms.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

/*

Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

 
Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargestQuickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    // SOL1: sort (force brute) Complexity O(NlogN)
    public int findKthLargestSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //SOL 2: MinHeap Complexity O(Nlogk)
    public int findKthLargestMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    // SOL3: QuickSort
    private int findKthLargestQuickSelect(int[] nums, int left, int right, int k) {
        // first call quickSelect(nums, 0, nums.length - 1, nums.length - k);

        if (left == right) { // If array only has 1 element return the element
            return nums[left];
        }

        // Pick the pivot, in this case is the last element of the range (could be random in the range)
        int pivotIndex = partition(nums, left, right);

        if (pivotIndex == k) { // Si el pivote está en la posición k, encontramos el k-ésimo mayor
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            // Search in the right part (excluding the pivot)
            return findKthLargestQuickSelect(nums, pivotIndex + 1, right, k);
        } else {
            // Search in the left part (excluding the pivot)
            return findKthLargestQuickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        //We use the last number of the partition (could be random number inside the range)
        int pivotVal = nums[right]; // value of the pivot
        int i = left; // the i is the correct position where the pivot will be (having the minor elements to its left)

        // swap the pivot through the elements of the range
        for (int j = left; j < right; j++) {
            if (nums[j] < pivotVal) {
                swap(nums, i, j);
                i++;
            }
        }

        // Put the pivot in the correct position (index of pivot is right)
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Main method to test findKthLargest function
    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();

        // Test case 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int result1 = kthLargestElement.findKthLargest(nums1, k1);
        System.out.println("Input: " + Arrays.toString(nums1) + ", k: " + k1);
        System.out.println("Expected: 5, Actual: " + result1);
        System.out.println();

        // Test case 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int result2 = kthLargestElement.findKthLargest(nums2, k2);
        System.out.println("Input: " + Arrays.toString(nums2) + ", k: " + k2);
        System.out.println("Expected: 4, Actual: " + result2);
        System.out.println();

        // Additional Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 1; // 1st largest is 5
        int result3 = kthLargestElement.findKthLargest(nums3, k3);
        System.out.println("Input: " + Arrays.toString(nums3) + ", k: " + k3);
        System.out.println("Expected: 5, Actual: " + result3);
        System.out.println();

        // Additional Test case 4
        int[] nums4 = {10, 7, 11, 5, 8};
        int k4 = 3; // 3rd largest is 8
        int result4 = kthLargestElement.findKthLargest(nums4, k4);
        System.out.println("Input: " + Arrays.toString(nums4) + ", k: " + k4);
        System.out.println("Expected: 8, Actual: " + result4);
        System.out.println();

        // Additional Test case 5
        int[] nums5 = {1, 3, 5, 7, 9};
        int k5 = 5; // 5th largest is 1
        int result5 = kthLargestElement.findKthLargest(nums5, k5);
        System.out.println("Input: " + Arrays.toString(nums5) + ", k: " + k5);
        System.out.println("Expected: 1, Actual: " + result5);
    }
}
