import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a')
                ret.append((char)(str.charAt(i) - 'a' + 'A'));
            else
                ret.append((char)(str.charAt(i) - 'A' + 'a'));
        }

        System.out.print(ret);
    }
}