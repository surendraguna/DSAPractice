package array;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubSets {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        help(a, res, new ArrayList<>());
        for(List<Integer> arr : res) {
            for(Integer i : arr)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    static void help(int[] a, List<List<Integer>> arr, List<Integer> cur) {
        arr.add(cur);
        for(int i = 0; i < a.length; i++) {
            cur.add(a[i]);
            help(a, arr, cur);
            cur.remove(cur.size() - 1);
        }
    }
}