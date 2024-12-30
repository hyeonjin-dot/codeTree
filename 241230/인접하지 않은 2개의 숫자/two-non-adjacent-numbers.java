import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] lst = new int[n];

        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            lst[i] = tmp;
        }

        int max = 0;
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 2; j < n; j++){
                int tmp = lst[i] + lst[j];
                max = max > tmp ? max : tmp;
            }
        }

        System.out.print(max);
    }
}