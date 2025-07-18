import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int len = str.length();
        int[] c = new int[len];
        int[] o = new int[len];
        int[] w = new int[len];

        if (str.charAt(0) == 'C')
            c[0] = 1;
        else if (str.charAt(0) == 'O')
            o[0] = 1;
        else 
            w[0] = 1;
        
        for (int i = 1; i < len; i++){
            if (str.charAt(i) == 'C')
                c[i] = c[i - 1] + 1;
            else if (str.charAt(i) == 'O')
                o[i] = o[i - 1] + 1;
            else 
                w[i] = w[i - 1] + 1;
        }

        int res = 0;
        for (int i = 0; i < len - 2; i++){
            for (int j = i + 1; j < len - 1; j++){
                for (int k = j + 1; k < len; k++){
                    if (c[i] != 0 && o[j] != 0 && w[k] != 0)
                        res++;
                }
            }
        }

        System.out.print(res);
    }
}