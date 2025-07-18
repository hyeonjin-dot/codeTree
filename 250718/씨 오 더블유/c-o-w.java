import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        long countC = 0;
        long countCO = 0;
        long countCOW = 0;

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == 'C') {
                countC++;
            } else if (ch == 'O') {
                countCO += countC;  // 지금까지의 C들을 이어받음
            } else if (ch == 'W') {
                countCOW += countCO;  // 지금까지의 CO들을 이어받음
            }
        }

        System.out.println(countCOW);
    }
}
