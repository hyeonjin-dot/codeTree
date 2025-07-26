import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int len = A.length();
        int[] lst = new int[len];
        for (int i = len - 2; i >= 0; i--){
            if (A.charAt(i) == ')' && A.charAt(i + 1) == ')')
                    lst[i] = lst[i + 1] + 1;
            else 
                lst[i] = lst[i + 1];
        }

        int res = 0;
        for (int i = 1; i < len; i++){
            if (A.charAt(i) == '(' && A.charAt(i - 1) == '(')
                    res += lst[i];
        }

        System.out.print(res);
    }
}