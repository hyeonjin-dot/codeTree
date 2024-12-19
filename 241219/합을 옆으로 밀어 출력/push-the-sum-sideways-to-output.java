import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < len; i++){
            sum += sc.nextInt();
        }

        String str = Integer.toString(sum);
        int idx = 1;
        for (int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(idx % str.length()));
            idx++;
        }
    }
}