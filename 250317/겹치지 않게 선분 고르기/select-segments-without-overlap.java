import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] segments;
    public static int max;

    public static void findMax(int idx){
        int[] tmp = new int[1001];
        
        for (int i = segments[idx][0]; i < segments[idx][1]; i++)
            tmp[i]++;

        int cnt = 1;
        for (int i = idx + 1; i < n; i++){
            boolean vaild = true;
            for (int j = segments[i][0]; j < segments[i][1]; j++){
                if (tmp[j] == 0)
                    tmp[j]++;
                else{
                    vaild = false;
                    break ;
                }
            }
            if (vaild)
                cnt++;
        }

        max = Math.max(max, cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        
        max = 0;
        for (int i = 0; i < n; i++)
            findMax(i);

        System.out.print(max);
    }
}