import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int a = 0;
        int b = 0;
        int win = 0; // a == b 0 a > b 1 a < b 2
        int res = 0;
        for (int i = 0; i < n; i++){
            String str = sc.nextLine().trim();
            if (str.charAt(0) == 'A')
                a += (int)(Integer.parseInt(str.substring(2)));
            else
                b += (int)(Integer.parseInt(str.substring(2)));
            
            int tmp = 0;
            if (a == b)
                tmp = 0;
            else if (a > b)
                tmp = 1;
            else 
                tmp = 2;

            if (win != tmp)
                res++;

            win = tmp;
        }

        System.out.print(res);
    }
}