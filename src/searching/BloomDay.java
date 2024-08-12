package searching;

public class BloomDay {
    public static void main(String[] args) {
        int a[] = {1,10,3,10,2,4}, m = 3, k = 1;
        System.out.println(Math.ceil(9.0 / 4));
        System.out.println(minDays(a, m, k));
    }
    static int minDays(int[] a, int m, int k) {
        if (m * k > a.length) return -1;
        int l, r;
        l = r = a[0];
        for(int i = 0; i < a.length; i++) {
            if(l > a[i]) l = a[i];
            if(r < a[i]) r = a[i];
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(a, m, k, mid)) r = m - 1;
            else l = m + 1;
        }
        return l;
    }

    static boolean isPossible (int a[], int m, int k, int mid) {
        int c = 0, p = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] < mid) c++;
            else {
                p += c / k;
                c = 0;
            }
        }
        p += c / k;
        if (p >= m) return true;
        return false;
    }
}
