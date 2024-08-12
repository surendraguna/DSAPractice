package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindMinIndex {
    public static void main(String[] args) {
        Integer a[] = {13881, 13969, 14173, 15115, 15253, 15484, 15700, 15781, 15967, 16290, 17294, 17448, 17950, 17987, 18814, 19253, 19290, 20317, 20350, 20406, 21360, 21422, 21717, 22168, 22222, 22374, 22992, 23232, 23780, 23971, 24062, 24407, 24421, 24790, 24998, 25457, 25682, 25760, 26288, 26330, 26429, 26676, 26773, 27012, 27514, 27544, 28460, 28539, 29061, 29528, 30113, 30215, 30352, 31082, 31433, 31448, 31604, 31825, 32233, 41, 53, 1129, 1159, 1162, 1171, 1536, 1933, 2219, 2678, 3024, 4452, 4571, 4664, 5368, 5675, 5805, 6050, 6425, 6549, 6803, 7459, 7683, 8706, 8906, 9040, 9269, 10431, 10609, 10713, 10975, 11376, 11458, 11711, 11830, 11968, 12439, 12453, 12805, 12918, 13670};
        List<Integer> arr = new ArrayList<>(Arrays.asList(a));
        System.out.println(findKRotation(arr));
    }

    public static int findKRotation(List<Integer> arr) {
        int l = 0, r = arr.size() - 1;
        int min = Integer.MAX_VALUE, index = -1;
        while(l <= r) {
            if(arr.get(l) <= arr.get(r)) {
                if(min >= arr.get(l)) return l;
                return index;
            }
            int m = (l + r) / 2;
            if(arr.get(l) <= arr.get(m)) {
                if(min >= arr.get(l)) {
                    index = l;
                    min = arr.get(l);
                }
                l = m + 1;
            } else {
                if(min >= arr.get(m)) {
                    index = m;
                    min = arr.get(m);
                }
                r = m - 1;
            }
        }
        return index;
    }
}