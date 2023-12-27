import recursion.RecursionQuestions;
import divideAndConquer.DivideAndConquer;
import arrayListQuestions.ArrayListQuestions;

import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int maze[][] = {{0, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 0, 1, 1}, {1, 0, 1, 1, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0}};

        long startTime = System.nanoTime();
        RecursionQuestions.floodFill(maze,0,0,5,1,"");
        long stopTime = System.nanoTime();
        System.out.println();
        System.out.println((stopTime - startTime) / 1e9);
    }
}