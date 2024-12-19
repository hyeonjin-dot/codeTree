import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine().trim();
        String b = sc.nextLine().trim();

        int len = a.length();
        int cnt = 0;
        for (int i = 0; i < len - 1; i++){
            if (a.substring(i, i+2).equals(b))
                cnt++;
        }
        System.out.print(cnt);
    }
}