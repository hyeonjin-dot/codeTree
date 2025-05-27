import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        int diff = 0;

        for (int i = 1; i < N; i++){
            if (seq[i] != seq[i - 1])
                diff++;
        }

        if (diff <= M){
            System.out.print(N);
            return ;
        }

        int[][][] dp = new int[N][M][N];

        for (int i = 0; i < N; i++){
            for (int j = 1; j < 5; j++){
                
            }
        }

    }
}