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

        int min = 900001;
        for (int i = 0; i < n; i++){ // 이 집에 모이는 거
            int sum = 0;
            for (int j = 0; j < n; j++){
                sum += lst[j] * Math.abs(i - j);
            }
            min = min < sum ? min : sum;
        }

        System.out.print(min);
    }
}