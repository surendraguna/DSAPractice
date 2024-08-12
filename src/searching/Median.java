package searching;

public class Median {
    public static void main(String[] args) {
        int a[] = {};
        int b[] = {1};
        System.out.println(findMedianSortedArrays(a, b));
    }
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int ind2 = n/2;
        int ind1 = ind2 - 1;
        int l, r, ele1, ele2, c;
        l = r = c = 0;
        ele1 = ele2 = -1;
        while(l < nums1.length && r < nums2.length) {
            if(nums1[l] < nums2[r]) {
                if(c == ind1) ele1 = nums1[l];
                if(c == ind2) ele2 = nums1[l];
                c++;
                l++;
            } else {
                if(c == ind1) ele1 = nums2[r];
                if(c == ind2) ele2 = nums2[r];
                c++;
                r++;
            }
        } 
        while(l < nums1.length) {
            if(c == ind1) ele1 = nums1[l];
            if(c == ind2) ele2 = nums1[l];
            c++;
            l++;
        }

        while(r < nums2.length) {
            if(c == ind1) ele1 = nums2[r];
            if(c == ind2) ele2 = nums2[r];
            c++;
            r++;
        }
        if(n%2 == 0) return (double)(ele1 + ele2) / 2;
        return ele2;
    }
}
