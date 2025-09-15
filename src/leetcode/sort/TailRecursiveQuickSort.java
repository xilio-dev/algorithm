package leetcode.sort;

import java.util.Arrays;

public class TailRecursiveQuickSort {

    public static void main(String[] args) {
        int[] arr = {12, 4, 7, 9, 2, 5, 1, 8, 6, 3};
        System.out.println("Original array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        // 使用while循环替代一个递归调用[2,4](@ref)
        while (low < high) {
            int pivotIndex = partition(arr, low, high); // 获取枢轴位置[2](@ref)

            // 比较两个分区的大小，总是递归处理较小的分区[2,4](@ref)
            if ((pivotIndex - low) <= (high - pivotIndex)) {
                // 左分区较小或相等，递归排序左分区[2](@ref)
                quickSort(arr, low, pivotIndex - 1);
                // 右分区较大，通过更新low指针进行迭代处理[2](@ref)
                low = pivotIndex + 1;
            } else {
                // 右分区较小，递归排序右分区[2](@ref)
                quickSort(arr, pivotIndex + 1, high);
                // 左分区较大，通过更新high指针进行迭代处理[2](@ref)
                high = pivotIndex - 1;
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // 使用三数取中法选择基准，提高分区平衡性[1,3](@ref)
        int mid = low + ((high - low)>>1);

        // 确保左端、中间、右端的三个数有序[3](@ref)
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }

        // 将中位数交换到最右端作为基准[3](@ref)
        swap(arr, mid, high);

        int pivot = arr[high]; // 选择最右元素作为基准[4](@ref)
        int i = low - 1; // i 指向小于枢轴元素的区域的右边界[4](@ref)

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1; // 返回枢轴的最终位置[4](@ref)
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
