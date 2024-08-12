package basic;

import java.util.ArrayList;
import java.util.List;

public class Josep {
    public static void main(String[] args) {
        int n = 100;
        int i = 1, ans = 0;
        while (i <= n) {
            ans = (ans + 2) % i;
            i++;
        }
        System.out.println(ans + 1);
        List<Integer> arr = new ArrayList<>();
        for (i = 1; i <= n; i++)
            arr.add(i);
        while (arr.size() > 1) {
            System.out.println(arr);
            List<Integer> sur = new ArrayList<>();
            for(i = 0; i < arr.size(); i++)
                if(i % 2 == 0)
                    sur.add(arr.get(i));
            if(arr.size() % 2 != 0)
                sur.add(0, sur.remove(sur.size() - 1));
            arr = sur;
        }
        System.out.println(arr);
    }
}
