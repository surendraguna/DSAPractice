package searching;

class ArraySplit {
    public static void main(String[] args) {
        int a[] = {1,4,4};
        System.out.println(splitArray(a, 2));
    }

    static int splitArray(int[] nums, int k) {
        int r = nums[0];
        for (int i = 1; i < nums.length; i++)
            r += nums[i];
        int l = 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(isPossible(nums, k, m)) r = m - 1;
            else l = m + 1;
        }
        return l;
    }

    static boolean isPossible(int[] a, int k, int m) {
        int cs = 0, cp = 1;
        for (int i = 0; i < a.length; i++) {
            if(cs + a[i] <= m) cs += a[i];
            else {
                cs = a[i];
                cp++;
            }
        }
        return cp <= k;
    }
}