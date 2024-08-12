package searching;

public class KoKo {
    public static void main(String[] args) {
        int a[] = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(a, 8));
    }

    static int minEatingSpeed(int[] p, int h) {
        int r = p[0];
        for (int i = 1; i < p.length; i++)  
            if(p[i] > r)
                r = p[i];
        int l = 0;
        while(l <= r) {
            int m = (l + r) / 2;
            if(isPossible(p, h, m)) {
                r = m - 1;
            }
            else l = m + 1;
        }
        return l;
    }

    static boolean isPossible (int[] p, int h, int m) {
        double temp = m;
        int flag = 0;
        for(int i = 0; i < p.length; i++) {
            flag += Math.ceil(p[i] / temp);
        }
        if (flag <= h)
            return true;
        return false;
    }
}
