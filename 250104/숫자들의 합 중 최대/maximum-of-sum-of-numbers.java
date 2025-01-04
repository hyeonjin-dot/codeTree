import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int max = 0;
        for (int i = x; i <= y; i++){
            int tmp = i;
            int sum = 0;
            while (tmp > 9){
                sum += (tmp % 10);
                tmp /= 10;
            }
            sum += tmp;
            max = Math.max(sum, max);
        }

        System.out.print(max);
    }
}