import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int len = str.length();

        int res = 0;
        for (int i = 0; i < len - 2; i++){
            if (str.charAt(i) == 'C'){
                for (int j = i + 1; j < len - 1; j++){
                    if (str.charAt(j) == 'O'){
                        for (int k = j + 1; k < len; k++){
                            if (str.charAt(k) == 'W')
                                res++;
                        }
                    }
                }
            }
        }

        System.out.print(res);
    }
}