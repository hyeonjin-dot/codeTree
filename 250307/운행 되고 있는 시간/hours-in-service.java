import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }
        
        int max = 0;

        for (int i = 0; i < N; i++){
            int[] lst = new int [1001];
            int sum = 0;

            for (int j = 0; j < N; j++){
                if (i == j)
                    continue;
                for (int a = A[j]; a < B[j]; a++)
                    lst[a] = 1;
            }
            for (int k = 0; k < 1001; k++){
                if (lst[k] > 0)
                    sum++;
            }
            max = Math.max(sum, max);
        }

        System.out.print(max);
    }
}