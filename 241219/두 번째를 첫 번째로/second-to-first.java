import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();
        char fir = str.charAt(0);
        char sec = str.charAt(1);

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == sec)
                ret.append(fir);
            else
                ret.append(str.charAt(i));
        }

        System.out.print(ret);
    }
}