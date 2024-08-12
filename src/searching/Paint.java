package searching;

import java.util.ArrayList;

public class Paint {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(30);
        a.add(40);
        System.out.println(findLargestMinDistance(a, 2));
    }

    static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int l, r;
        l = r = boards.get(0);
        for (int i = 1; i < boards.size(); i++) {
            r += boards.get(i);
            if(l > boards.get(i)) l = boards.get(i);
        }
        while (l <= r) {
            int m = (l + r) / 2;
            if(poss(boards, k, m)) r = m - 1;
            else l = m + 1;
        }
        return l;
    }

    static boolean poss(ArrayList<Integer> a, int k, int m) {
        int p = 0, b = 0;
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) > m) return false;
            if(b + a.get(i) <= m) b += a.get(i);
            else {
                p++;
                b = a.get(i);
            } 
        }
        while(b > 0) {
            b -= m;
            p++;
        }
        return p <= k;
    }
}
