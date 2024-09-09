public class CountingSort {
    public static void sort012(int[] arr) {
        int[] count = new int[3];

        // Count occurrences and calculate cumulative counts
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build output array and copy back to original array
        int[] output = new int[arr.length];
        for (int num : arr) {
            output[count[num] - 1] = num;
            count[num]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {0, 1, 2, 1, 0, 2, 1, 0},
                {2, 2, 2, 2},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {2, 0, 1},
                {}
        };

        for (int[] testCase : testCases) {
            System.out.println("Input: " + java.util.Arrays.toString(testCase));
            sort012(testCase);
            System.out.println("Output: " + java.util.Arrays.toString(testCase));
            System.out.println();
        }
    }
}