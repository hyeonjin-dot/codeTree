import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        int total = 0;
        int[][] lst = new int[n][2];
        for (int i = 0; i < n; i++) {
            lst[i][1] = sc.nextInt(); // cnt
            lst[i][0] = sc.nextInt(); // value
            total += lst[i][1];
        }

        int[] l = new int[total];
        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < total; i++){
            l[i] = lst[idx][0];
            cnt++;
            if (cnt >= lst[idx][1]){
                cnt = 0;
                idx++;
            }
        }
        Arrays.sort(l);
        int max = 0;
        for (int i = 0; i < total / 2; i++){
            int sum = l[i] + l[total - i - 1];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
