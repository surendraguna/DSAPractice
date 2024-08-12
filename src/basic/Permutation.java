package basic;

import java.util.ArrayList;
import java.util.List;

class Permutation {
    public static void main(String[] args) {
        int a[] = {1, 2, 3};
        List<ArrayList<Integer>> arr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean freq[] = new boolean[a.length];
        permutation(a, arr, temp, freq);
        System.out.println(arr); 
    }

    private static void permutation(int[] a, List<ArrayList<Integer>> arr, List<Integer> temp, boolean[] freq) {
        if(temp.size() == a.length) {
            arr.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < a.length; i++) {
            if(!freq[i]) {
                freq[i] = true;
                temp.add(a[i]);
                permutation(a, arr, temp, freq);
                temp.remove(temp.size() - 1);
                freq[i] = false;
            }
        }
    }

}