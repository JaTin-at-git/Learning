import recursion.RecursionQuestions;
import divideAndConquer.DivideAndConquer;
import arrayListQuestions.ArrayListQuestions;

import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        System.out.println(ArrayListQuestions.clearMaze( 1, 2,10,11));
        long stopTime = System.nanoTime();
        System.out.println((stopTime - startTime) / 1e9);
    }
}