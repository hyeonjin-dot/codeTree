import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String one = sc.nextLine().trim();
        String two = sc.nextLine().trim();

        int fir = 0;
        int sec = 0;

        for (int i = 0; i < one.length(); i++){
            if (one.charAt(i) <= '9' && one.charAt(i) >= '0'){
                fir *= 10;
                fir += one.charAt(i) - '0';
            }
        }

        for (int i = 0; i < two.length(); i++){
            if (two.charAt(i) <= '9' && two.charAt(i) >= '0'){
                sec *= 10;
                sec += two.charAt(i) - '0';
            }
        }

        System.out.print(fir+sec);
    }
}