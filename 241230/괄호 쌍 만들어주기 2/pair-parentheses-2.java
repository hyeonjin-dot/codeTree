import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();

        int cnt = 0;
        for (int i = 0; i < str.length() - 2; i++){
            if (str.charAt(i) == '(' && str.charAt(i + 1) == '('){
                for (int j = i + 2; j < str.length() - 1; j++){
                    if (str.charAt(j) == ')' && str.charAt(j + 1) == ')')
                        cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}