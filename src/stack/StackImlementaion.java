package stack;

import java.util.Scanner;
import java.util.Stack;

public class StackImlementaion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Scanner inp = new Scanner(System.in);
        boolean flag = true;
        System.out.print("1. Push\n2. Pop\n3. Peek\n4. Exit\n");
        while (flag) {
            System.out.println("Enter option from above");
            int ch = inp.nextInt();
            switch (ch) {
                case 1 -> st.push(inp.nextInt());
                case 2 -> {
                    try {
                        st.pop();
                    } catch (Exception e) {
                        System.out.println("Empty Stack");
                    }
                }
                case 3 -> System.out.println(st.peek());
                case 4 -> flag = false;
                default -> System.out.println("Enter correct option");
            }
        }
        inp.close();
    }
}
