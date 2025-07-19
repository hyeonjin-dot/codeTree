import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        int[] line = new int[2000001];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        
        int[] tmp = new int[n];
        Arrays.sort(segments, (a, b) -> Integer.compare(a[1], b[1]));
        int check = 0;
        for (int i = 0; i < n; i++){
            if (i == 0){
                check = segments[i][1];
                continue;
            }
            if (segments[i][0] <= check){
                tmp[i]++;
                tmp[i - 1]++;
            }
            check = segments[i][1];
        }

        int res = 0;
        for (int i = 0; i < n; i++){
            if (tmp[i] == 0)
                res++;
        }

        System.out.print(res);
    }
}