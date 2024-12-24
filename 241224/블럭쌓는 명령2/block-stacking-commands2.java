import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] lst = new int[n + 1];

        for (int i = 0; i < k; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            for (int j = start; j <= end; j++)
                lst[j]++;
        }

        System.out.print(Arrays.stream(lst).max().getAsInt());
    }
}