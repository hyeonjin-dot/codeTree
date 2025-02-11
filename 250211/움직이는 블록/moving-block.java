import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++){
            lst[i] = sc.nextInt();
            sum += lst[i];
        }

        int stand = sum / n;
        sum = 0;
        for (int i = 0; i < n; i++){
            if (lst[i] > stand)
                sum += (lst[i] - stand);
        }

        System.out.print(sum);
    }
}