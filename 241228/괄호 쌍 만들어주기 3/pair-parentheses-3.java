import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();

        int cnt = 0;

        for (int i = 0; i < str.length() - 1; i++){
            for (int j = i; j < str.length(); j++){
                if (str.charAt(i) == ')')
                    break;
                if (str.charAt(j) == ')')
                    cnt++;
            }
        }

        System.out.print(cnt);

    }
}