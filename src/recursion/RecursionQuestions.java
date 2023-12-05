package recursion;

public class RecursionQuestions {

    private static boolean isSortedHelper(int arr[], int index) {
        if (index == arr.length - 1) return true;
        else if (arr[index] > arr[index + 1]) return false;
        else return isSortedHelper(arr, index + 1);
    }

    public static boolean isSorted(int arr[]) {
        return isSortedHelper(arr, 0);
    }

}
