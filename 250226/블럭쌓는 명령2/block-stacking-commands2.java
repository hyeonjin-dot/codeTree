import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] block = new int[N + 1];

        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            for (int j = A; j <= B; j++)
                block[j]++;
        }

        System.out.print(Arrays.stream(block).max().getAsInt());
       
    }
}