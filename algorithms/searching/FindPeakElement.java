package algorithms.searching;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // correct pattern, search in the right part
                left = mid + 1;
            } else {
                // incorrect pattern, peak element. Search in the left
                right = mid;
            }
        }

        return left; // index of the peak element
    }

    public static void main(String[] args) {
        testFindPeakElement(new int[]{1, 2, 3, 1}, 2); // Output puede ser 2
        testFindPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}, 5); // Output puede ser 1 o 5
        testFindPeakElement(new int[]{1}, 0); // Solo un elemento, debe devolver 0
        testFindPeakElement(new int[]{1, 2}, 1); // Último es un pico
        testFindPeakElement(new int[]{2, 1}, 0); // Primero es un pico
        testFindPeakElement(new int[]{1, 3, 2, 4, 1, 5}, 1); // Puede devolver 1 o 3
        testFindPeakElement(new int[]{6, 5, 4, 3, 2, 3, 2}, 0); // Primer elemento es un pico
    }

    private static void testFindPeakElement(int[] nums, int expected) {
        int result = findPeakElement(nums);
        System.out.printf("Input: %s, Expected: %d, Obtained: %d%n",
                java.util.Arrays.toString(nums), expected, result);
    }
}
