import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();
        String ck = sc.nextLine().trim();

        // StringBuilder pushed = new StringBuilder();

        int len = str.length();
        int idx = -1;
        for (int i = 0; i < len; i++){
            StringBuilder pushed = new StringBuilder();
            pushed.append(str.substring(i, len));
            pushed.append(str.substring(0, i));

            if (pushed.toString().equals(ck)){
                idx = i;
                break;
            }
        }

        System.out.print(idx);
    }
}