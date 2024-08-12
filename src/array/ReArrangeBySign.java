package array;

public class ReArrangeBySign {
    public static void main(String[] args) {
        int[] a = {3,1,-2,-5,2,-4};
        int res[] = new int[a.length];
        int p, n;
        p = n = 0;
        for(int i = 0; i < a.length - 1; i += 2) {         
            while(p < a.length && a[p] < 0) 
                p++;
            while(n < a.length && a[n] > 0)
                n++;
            res[i] = a[p++];  
            res[i + 1] = a[n++];  
        }
        System.out.println(res.toString());
    }
}
