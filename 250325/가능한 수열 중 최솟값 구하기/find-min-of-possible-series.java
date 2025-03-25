import java.util.*;

public class Main {
    public static int n;
    public static StringBuffer str = new StringBuffer();
    public static long min;

    public static long change(){
        String tmp = str.toString();

        int len = tmp.length();
        long res = 0;

        for (int i = 0; i < len; i++){
            res += (long)(tmp.charAt(i) - '0');
            if (i != len - 1)
                res *= 10;
        }
        return res;
    }

    public static boolean isValid(){
        int len = str.length();

        if (n == 1)
            return true;

        for (int i = 0; i < len - 1; i++){
            for (int j = 1; j <= len / 2; j++){
                if (i + j >= len)
                    continue ;
                String tmp = str.toString().substring(i, i + j);
                String other = "";
                if (i + 2 * j < len)
                    other = str.toString().substring(i + j, i + 2 * j);
                else
                    other = str.toString().substring(i + j);
                if (other.contains(tmp))
                    return false;
            }
        }

        return true;
    }

    public static void find(int idx){
        if (idx == n){
            if (isValid())
                min = Math.min(change(), min);
            return ;
        }

        for (int i = 4; i <= 6; i++){
            char a = (char)('0' + i);
            str.append(a);
            find(idx + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        min = Integer.MAX_VALUE;

        find(0);
        System.out.print(min);
    }
}