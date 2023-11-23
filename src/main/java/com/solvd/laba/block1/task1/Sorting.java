package com.solvd.laba.block1.task1;

public class Sorting {
    public static int[] mergeSort(int[] arr) {
        return mergeSort(arr, 0, arr.length);
    }

    private static int[] mergeSort(int[] arr, int start, int end) {
        int delta = end - start;
        if (delta == 1)
            return new int[]{arr[start]};

        int[] arr1 = mergeSort(arr, start, start + (delta) / 2);
        int[] arr2 = mergeSort(arr, start + (delta) / 2, end);
        int[] res = new int[arr1.length + arr2.length];
        int i1 = 0;
        int i2 = 0;
        while (i1 != arr1.length && i2 != arr2.length) {
            if (arr1[i1] < arr2[i2]) {
                res[i1 + i2] = arr1[i1];
                i1++;
            } else {
                res[i1 + i2] = arr2[i2];
                i2++;
            }
        }
        if (i1 == arr1.length) {
            for (; i2 < arr2.length; i2++)
                res[i1 + i2] = arr2[i2];
        } else
            for (; i1 < arr1.length; i1++)
                res[i1 + i2] = arr1[i1];
        return res;
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start != end) {
            int pivot = arr[end - 1];
            int imax = start;
            for (int i = start; i < end; i++) {
                if (pivot >= arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[imax];
                    arr[imax] = temp;
                    imax++;
                }
            }
            quickSort(arr, start, imax - 1);
            quickSort(arr, imax, end);
        }
    }

    public static void main(String[] args) { // demonstration
        RandomArrayGenerator arrGen = new RandomArrayGenerator();
        int[] arr1 = arrGen.getIntArray(5);
        int[] arr2 = arrGen.getIntArray(5);
        int[] arr3 = arrGen.getIntArray(5, 200);
        int[] arr4 = arrGen.getIntArray(10);

        int[][] arrs = new int[][]{arr1, arr2, arr3, arr4};

        //merge sort demo
        for (int[] arr : arrs) {
            System.out.print("Given array: ");
            printArray(arr);
            System.out.println();
            System.out.print("Merge sorted array: ");
            printArray(mergeSort(arr));
            System.out.println();
            System.out.println();
        }
        System.out.println("------------------");

        //quick sort demo
        for (int[] arr : arrs) {
            System.out.print("Given array: ");
            printArray(arr);
            System.out.println();
            quickSort(arr);
            System.out.print("Quick sorted array: ");
            printArray(arr);
            System.out.println();
            System.out.println();
        }
    }

    private static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
    }
}
