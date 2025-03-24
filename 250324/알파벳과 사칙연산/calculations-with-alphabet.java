import java.util.*;
public class Main {
    public static String expression;
    public static int max;
    public static int len;
    public static int[] alpha;
    public static StringBuffer str = new StringBuffer();

    public static int circul(){
        int res = alpha[expression.charAt(0) - 'a'];

        for (int i = 2; i < len; i += 2){
            char a = expression.charAt(i - 1);
            int num = alpha[expression.charAt(i) - 'a'];

            if (a == '+')
                res += num;
            else if (a == '-')
                res -= num;
            else
                res *= num;
        }

        return res;
    }

    public static void find(int idx){
        if (idx == 6){
            max = Math.max(max, circul());
            return ;
        }

        for (int i = 1; i <= 4; i++){
            if (alpha[idx] > 0)
                continue;
            
            alpha[idx] = i;
            find(idx + 1);
            alpha[idx] = 0;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expression = sc.next();
        max = Integer.MIN_VALUE;
        len = expression.length();
        alpha = new int[6];
        
        find(0);
        System.out.print(max);
    }
}