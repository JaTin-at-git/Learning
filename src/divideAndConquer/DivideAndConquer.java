package divideAndConquer;

import java.util.Arrays;

public class DivideAndConquer {
    //used to count the number of times a function is called
    static int functionCallCount = 0;

    //function to merge sort the given array
    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) return;

        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    private static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];

        int i = si, j = mid + 1, k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= ei) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, si, k);
    }

    //function to quick sort the given array
    public static void quickSort(int arr[], int si, int ei) {
//        System.out.println("FC: " + ++functionCallCount);
        if (si >= ei) return;

        int pivot = arr[ei];
        int i = -1;

        for (int j = 0; j < ei; j++)
            if (arr[j] <= pivot) {
                int temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        int temp = arr[++i];
        arr[i] = arr[ei];
        arr[ei] = temp;

        quickSort(arr, si, i - 1);
        quickSort(arr, i + 1, ei);

    }

}
