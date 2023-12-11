import recursion.RecursionQuestions;
import divideAndConquer.DivideAndConquer;
import arrayListQuestions.ArrayListQuestions;

import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ArrayList<Integer> arrLi = new ArrayList<>();
        Arrays.stream(arr).forEach(arrLi::add);
        System.out.println(ArrayListQuestions.storeMaxWater(arrLi));
    }
}