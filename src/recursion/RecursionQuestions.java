package recursion;

public class RecursionQuestions {

    private static boolean isSortedHelper(int arr[], int index) {
        if (index == arr.length - 1) return true;
        else if (arr[index] > arr[index + 1]) return false;
        else return isSortedHelper(arr, index + 1);
    }

    //returns true if array is sorted in ascending, false otherwise
    public static boolean isSorted(int arr[]) {
        return isSortedHelper(arr, 0);
    }

    //returns num raised to power pow, pow shall be non negative
    public static long powerPositive(int num, int pow) {
        if (pow == 0) return 1;
        long halfPow = powerPositive(num, pow / 2);
        if ((pow & 1) == 1) return num * halfPow * halfPow;
        else return halfPow * halfPow;
    }

    //returns number of ways a floor of dimension 2*length can be covered by tiles of dimension 2*1
    public static int tilingWays(int length) {
        if (length == 0 || length == 1) return 1;
        return tilingWays(length - 1) + tilingWays(length - 2);
    }

    //return number of ways in which n friends can stand, if a person can stand alone or in a pair
    public static int singleOrPair(int n) {
        if (n == 0 || n == 1) return 1;
        return (singleOrPair(n - 1)) + ((n - 1) * singleOrPair(n - 2));
    }

    //prints non consecutive 1 binary strings of length n
    private static void printNonCon1BinStrHelper(int n, char lastPlace, String sb) {
        if (n == 0) System.out.println(sb);
        else {
            printNonCon1BinStrHelper(n - 1, '0', sb + '0');
            if (lastPlace == '0') printNonCon1BinStrHelper(n - 1, '1', sb + '1');
        }
    }

    public static void printNonCon1BinStr(int n) {
        printNonCon1BinStrHelper(n, '0', "");
    }

}
