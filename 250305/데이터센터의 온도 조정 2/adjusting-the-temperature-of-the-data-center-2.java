import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt(); // 이하
        int g = sc.nextInt(); // 중간
        int h = sc.nextInt(); // 이후
        int[] ta = new int[n];
        int[] tb = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
            min = Math.min(min, ta[i]);
            max = Math.max(max, tb[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = min - 1; i <= max + 1; i++){
            int sum = 0;
            for (int j = 0; j < n; j++){
                if (i < ta[j])
                    sum += c;
                else if (i >= ta[j] && i <= tb[j])
                    sum += g;
                else
                    sum += h;
            }
            res = Math.max(res, sum);
        }

        System.out.print(res);
    }
}