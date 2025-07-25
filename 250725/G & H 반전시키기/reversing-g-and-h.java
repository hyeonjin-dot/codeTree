import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        
        int len = a.length();

        int res = 0;
        for (int i = 1; i < len; i++){
            if (i == 1){
                if (a.charAt(i) == b.charAt(i)){
                    if (a.charAt(i - 1) != b.charAt(i - 1))
                        res++;
                }
            }

            if (a.charAt(i) != b.charAt(i)){
                if (a.charAt(i - 1) == b.charAt(i - 1))
                    res++;
            }

        }

        System.out.print(res);
    }
}