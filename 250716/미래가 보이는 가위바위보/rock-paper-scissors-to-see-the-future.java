import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] matches = new char[n];
        int[] h = new int[n]; // 주
        int[] s = new int[n]; // 가
        int[] p = new int[n]; // 보
        for (int i = 0; i < n; i++) {
            matches[i] = sc.next().charAt(0);
            if (matches[i] == 'H')
                p[i] = 1;
            else if (matches[i] == 'S')
                h[i] = 1;
            else
                s[i] = 1;
        }
        
        for (int i = 1; i < n; i++){ // 누적
            p[i] = p[i - 1] + p[i];
            h[i] = h[i - 1] + h[i];
            s[i] = s[i - 1] + s[i];
        }

        int max = 0;
        for (int i = 0; i < n - 1; i++){ // 여기까지만 내
            int before = Math.max(p[i], h[i]);
            before = Math.max(before, s[i]);
            int after = Math.max(p[n - 1] - p[i], h[n - 1] - h[i]);
            after = Math.max(after, s[n - 1] - s[i]);
            max = Math.max(max, before + after);
        }

        System.out.print(max);

    }
}