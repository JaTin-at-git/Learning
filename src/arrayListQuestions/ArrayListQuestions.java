package arrayListQuestions;

import java.util.ArrayList;
import java.util.List;

public class ArrayListQuestions {

    //given various heights, calculate the max water that can be stored using any two of these lines
    public static int storeMaxWater(ArrayList<Integer> arr) {
        int maxWater = 0;

        int lp = 0;
        int rp = arr.size() - 1;

        while (lp < rp) {
            maxWater = Math.max(maxWater, (rp - lp) * (Math.min(arr.get(lp), arr.get(rp))));
            System.out.printf("lp:%d rp:%d maxWater:%d\n", lp, rp, maxWater);
            //amount is governed by the side with less height
            if (arr.get(lp) < arr.get(rp)) lp++;
            else rp--;
        }

        return maxWater;
    }

    //given a string, find all the subsequences and store them in arraylist
    public static ArrayList<String> getAllSubstrings(String str) {
        if (str.isEmpty()) return new ArrayList<>(List.of(""));

        ArrayList<String> res = new ArrayList<>();
        char ch = str.charAt(0);
        ArrayList<String> preSubStrings = getAllSubstrings(str.substring(1));

        for (String pre : preSubStrings) {
            res.add("" + pre);
            res.add(ch + pre);
        }

        return res;
    }


    //returns all the keypad combination possible for given numeric sequence
    public static ArrayList<String> getAllKeypadCombinations(String str) {
        if (str.isEmpty()) return new ArrayList<>();
        String bindings[] = {"?!", "abc", "def", "ghi", "jkl", "mnop", "qrst", "uv", "wxyz", ".;"};
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> recRes = getAllKeypadCombinations(str.substring(1));
        char preKeyPress[] = bindings[str.charAt(0) - '0'].toCharArray();
        if (recRes.isEmpty()) {
            for (char ch : preKeyPress) {
                res.add(ch + "");
            }
        } else {
            for (String post : recRes)
                for (char pre : preKeyPress)
                    res.add(pre + post);
        }
        return res;
    }

    public static ArrayList<String> stairsProblem(int n) {
        if (n == 0) {
            return new ArrayList<>(List.of(""));
        } else if (n < 0) {
            return new ArrayList<>();
        }

        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> recRes1 = stairsProblem(n - 1);
        ArrayList<String> recRes2 = stairsProblem(n - 2);
        ArrayList<String> recRes3 = stairsProblem(n - 3);

        for (String pattern : recRes1) res.add(1 + pattern);
        for (String pattern : recRes2) res.add(2 + pattern);
        for (String pattern : recRes3) res.add(3 + pattern);

        return res;
    }

    public static ArrayList<String> clearMaze(int sr, int sc, int er, int ec) {
        ArrayList<String> res = new ArrayList<>();

        //base
        if (sr == er && sc == ec)
            return new ArrayList<>(List.of(""));

        //check and move
        if (sr < er)
            for (String post : clearMaze(sr + 1, sc, er, ec))
                res.add("S" + post);
        else if (sr > er)
            for (String post : clearMaze(sr - 1, sc, er, ec))
                res.add("N" + post);
        if (sc < ec)
            for (String post : clearMaze(sr, sc + 1, er, ec))
                res.add("E" + post);
        else if (sc > ec)
            for (String post : clearMaze(sr, sc - 1, er, ec))
                res.add("W" + post);

        //return
        return res;
    }



}
