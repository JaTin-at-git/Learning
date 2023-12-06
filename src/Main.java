import recursion.RecursionQuestions;
import divideAndConquer.DivideAndConquer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 8, 3, 4, 2, 6, 8, 3, 2};
        System.out.println(Arrays.toString(arr));
        DivideAndConquer.mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}