import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int high = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            high = Math.max(h[i], high);
            min = Math.min(h[i], min);
        }


        int ret = 0;
        for (int i = high - 1; i >= min; i--){
            int cnt = 0;
            boolean ice = false;
            for (int j = 0; j < n; j++){
                if (h[j] - i > 0){
                    ice = true;
                    continue;
                }
                if (ice){
                    cnt++;
                    ice = false;
                }
            }
            if (ice)
                cnt++;
            ret = Math.max(cnt, ret);
        }

        System.out.print(ret);
    }
}