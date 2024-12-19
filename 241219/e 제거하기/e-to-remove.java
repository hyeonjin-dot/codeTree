import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();

        StringBuilder ret = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'e' && cnt == 0)
                cnt++;
            else
                ret.append(str.charAt(i));
        }

        System.out.print(ret);
    }
}