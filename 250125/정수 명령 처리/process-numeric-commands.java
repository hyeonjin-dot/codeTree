import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++){
            String tmp = sc.nextLine().trim();

            if (tmp.charAt(0) == 'e'){
                if (stack.empty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }else if (tmp.charAt(0) == 's')
                System.out.println(stack.size());
            else if (tmp.charAt(0) == 't')
                System.out.println(stack.peek());
            else if (tmp.charAt(1) == 'u'){
                int num = Integer.parseInt(tmp.substring(5));
                stack.push(num);
            }else
                System.out.println(stack.pop());
        }
    }
}