import java.util.*;

public class Main {
    public static int n;
    public static StringBuffer str = new StringBuffer();
    public static long min;
    public static boolean found;

    public static void change(){
        String tmp = str.toString();

        for (int i = 0; i < str.length(); i++)
            System.out.print(str.charAt(i));
    }

    public static boolean isValid(){
        int len = str.length();
        String copy = str.toString();

        if (n == 1)
            return true;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; i + 2 * j <= len; j++) {
                boolean same = true;
                for (int k = 0; k < j; k++) {
                    if (str.charAt(i + k) != str.charAt(i + j + k)) {
                        same = false;
                        break;
                    }
                }
                if (same) return false;
            }
        }

        return true;
    }

    public static void find(int idx){
        if (found)
            return ;

        if (idx == n){
            change();
            found = true;
            return ;
        }

        for (int i = 4; i <= 6; i++){
            char a = (char)('0' + i);

            if (str.length() > 0 && str.charAt(str.length() - 1) == a)
                continue;

            str.append(a);
            if (isValid())
                find(idx + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        min = Long.MAX_VALUE;
        found = false;
        find(0);
    }
}