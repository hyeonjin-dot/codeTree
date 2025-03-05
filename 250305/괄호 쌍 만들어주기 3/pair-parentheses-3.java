import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        int len = str.length();
        int res = 0;
        
        for (int i = 0; i < len - 1; i++){
            if (str.charAt(i) == '('){
                for (int j = i + 1; j < len; j++){
                    if (str.charAt(j) == ')')
                        res++;
                }
            }
        }

        System.out.print(res);
    }
}