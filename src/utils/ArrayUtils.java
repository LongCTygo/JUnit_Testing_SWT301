package utils;

public class ArrayUtils {
    public static int findMax(int[] numbers, int startIndex, int endIndex) {
        if (numbers == null || startIndex < 0 || endIndex >= numbers.length || startIndex > endIndex) {
            throw new IllegalArgumentException("Invalid Arguments!");
        }

        int max = numbers[startIndex];
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int findMin(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int[] removeDuplicates(int[] numbers) {
        int[] uniqueNumbers = new int[numbers.length];
        int uniqueCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (!contains(uniqueNumbers, numbers[i])) { // Bug: Should check for !contains(numbers, numbers[i])
                uniqueNumbers[uniqueCount] = numbers[i];
                uniqueCount++;
            }
        }
        int[] result = new int[uniqueCount];
        System.arraycopy(uniqueNumbers, 0, result, 0, uniqueCount);
        return result;
    }

    private static boolean contains(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int index = 0;

        for (int i = 0; i < arr1.length; i++) {
            merged[index] = arr1[i];
            index++;
        }
        for (int j = 0; j < arr2.length; j++) {
            merged[index] = arr2[j];
            index++;
        }
        return merged;
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
