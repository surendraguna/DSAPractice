package searching;

public class KthElement {
    public static void main(String[] args) {
        int a[] = {2, 3, 6, 7, 9};
        int b[] = {1, 4, 8, 10};
        System.out.println(kthElement(a, b, a.length, b.length, 4));   
    }
    
    static long kthElement( int a[], int b[], int n, int m, int k) {
        int l, r, c;
        l = r = c = 0;
        while(l < n && r < m) {
            if(a[l] < b[r]) {
                if(c == k) 
                    return (long) a[l];
                l++;
            } else {
                if(c == k)
                    return (long) b[r];
                r++;
            }
            c++;
        }
        
        while(l < n) {
            if(c == k) 
                return (long) a[l];
            c++;
            l++;
        }
        while(r < m) {
            if(c == k)
                return (long) b[r];
            c++;
            r++;
        }
        return 0;
    }
}
