package arrayListQuestions;

import java.util.ArrayList;

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

}
