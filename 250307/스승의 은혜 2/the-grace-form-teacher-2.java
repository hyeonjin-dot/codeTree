import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        Arrays.sort(p);

        int max = 0;

        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = 0; j < n; j++){
                if (i == j)
                    sum += (p[j] / 2);
                else
                    sum += p[j];

                if (sum > b){
                    max = Math.max(j, max);
                    break ;
                }
            }
            if (sum <= b)
                max = n;
        }

        System.out.print(max);
    }
}