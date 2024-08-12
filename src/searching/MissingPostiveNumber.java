package searching;

class MissingPostiveNumber {
    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4};
        System.out.println(findKthPositive(a, 2));
    }
    static int findKthPositive(int[] a, int k) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if ((a[m] - m + 1) <= k) l = m + 1;
            else r = m - 1;
        }
        return r + k + 1;
    }
}