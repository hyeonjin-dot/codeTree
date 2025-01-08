import java.util.*;

public class Main {
    public static boolean palindrome(int i){
        if (i < 10)
            return true;
        else if (i >= 10 && i < 100){
            if (i % 10 == i / 10)
                return true;
        }else {
            String tmp = Integer.toString(i);
            int len = tmp.length();
            int idx = 0;
            while (idx < len / 2){
                if (tmp.charAt(idx) != tmp.charAt(len - 1 - idx))
                    return false;
                idx++;
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int res = 0;
        
        for (int i = x; i <= y; i++){
            if (palindrome(i))
                res++;
        }
        
        System.out.print(res);
    }
}