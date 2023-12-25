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

}
