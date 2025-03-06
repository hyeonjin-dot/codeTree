import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        int len = input.length();
        int res = 0;

        for (int i = 0; i < len - 3; i++){
            if (input.charAt(i) == '(' 
                && input.charAt(i + 1) == '('){
                    for (int j = i + 2; j < len - 1; j++){
                        if (input.charAt(j) == ')' 
                            && input.charAt(j + 1) == ')')
                                res++;
                    }
                }
        }

        System.out.print(res);
    }
}