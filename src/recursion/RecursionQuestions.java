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

    public static void printPermutations(String str, String post) {
        //base cases
        if (str.isEmpty()) System.out.print(post + "  ");

        //check and work
        int index = str.length();
        while (index > 0) {
            char ch = str.charAt(--index);
            printPermutations(str.substring(0, index) + str.substring(index + 1), ch + post);
        }
    }

    public static void printEncoding(String code, String pre) {
        //base case or pruning
        if (code.isEmpty()) {
            System.out.print(pre + " ");
            return;
        } else if (code.charAt(0) == '0') {
            return;
        }

        //check and move
        for (int i = 0; i < 2 && i < code.length(); i++) {
            int intValue = Integer.parseInt(code.substring(0, i + 1));
            if (intValue >= 1 && intValue <= 26)
                printEncoding(code.substring(i + 1), pre + (char) ('a' + intValue - 1));
            else
                return;
        }
    }

    public static void floodFill(int area[][], int sr, int sc, int er, int ec, String pre) {
        //area[][] = 0 means valid and unoccupied, 1 = invalid, -1 = valid but occupied
        //base case
        if (sr == er && sc == ec) {
            System.out.printf("%s ", pre);
            return;
        }

        area[sr][sc] = -1;
        if (sr - 1 >= 0 && area[sr - 1][sc] == 0)
            floodFill(area, sr - 1, sc, er, ec, pre + "N");
        if (sc + 1 < area[0].length && area[sr][sc + 1] == 0)
            floodFill(area, sr, sc + 1, er, ec, pre + "E");
        if (sr + 1 < area.length && area[sr + 1][sc] == 0)
            floodFill(area, sr + 1, sc, er, ec, pre + "S");
        if (sc - 1 >= 0 && area[sr][sc - 1] == 0)
            floodFill(area, sr, sc - 1, er, ec, pre + "W");
        area[sr][sc] = 0;
        return;
    }


}
