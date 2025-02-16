import  java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();

        Stack<Integer> stack = new Stack<>();

        int len = str.length();

        for (int i = 0; i < len; i++){
            if (str.charAt(i) == '(')
                stack.push(0);
            else {
                if (!stack.empty())
                    stack.pop();
                else {
                    System.out.print("No");
                    return ;
                }

            }
        }

        if (stack.empty())
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}