package searching;

public class FindSqrt {
    public static void main(String[] args) {
        int x = 5;
        int l = 0, r = x;
        while (l <= r) {
            int m = (l + r) / 2;  
            if(m * m <= x){
                l = m + 1;
            } else 
                r = m - 1;
        }
        System.out.println(r);
        System.out.println(find(10));
    }

    private static double find(int x) {
        double l = 0, r = x;
        double delta = 1e-10; // le-6
        while ((r - l) > delta) {
            double m = (l + r) / 2;  
            if(m * m <= x){
                l = m;
            } else 
                r = m;
        }
        return Double.parseDouble(String.format("%.10f", l));
    }
}
