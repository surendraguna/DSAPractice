package algorithm;

import java.util.ArrayList;

public class SpecialNumber {
    public static void main(String[] args) {
        ArrayList<Integer> a = helper(5, 75);
        System.out.println(a);
    }

    private static ArrayList<Integer> helper(int l, int r) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = l; i <= r; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 1; j * j <= i; j++) {
                if(i % j == 0) {
                    temp.add(j);
                    if(i/j != j) temp.add(i/j);
                }
            }
            if(temp.size() == 4) a.add(i);
        }
        return a;
    }
}
