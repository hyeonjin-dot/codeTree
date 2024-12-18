import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();
        int len = str.length();

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < len; i++){
            if (i % 2 == 1)
                tmp.append(str.charAt(i));
        }

        tmp.reverse();
        System.out.print(tmp);
    }
}