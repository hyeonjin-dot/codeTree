import java.util.*;
public class Main {
    public static int n;
    public static int[] arr;
    public static int min;
    public static int aSum;
    public static int aCnt;
    public static int bSum;
    public static int sum;

    public static void find(int idx){
        if ((idx == 2 * n && aCnt == n) || aCnt == n){
            bSum = sum - aSum;
            min = Math.min(Math.abs(aSum - bSum), min);
            return ;
        }

        if (idx == 2 * n)
            return ;

        aSum += arr[idx];
        aCnt++;
        find(idx + 1);
        aSum -= arr[idx];
        aCnt--;
        find(idx + 1);

        return ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        sum = 0;
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        min = Integer.MAX_VALUE;
        aSum = 0;
        aCnt = 0;

        find(0);

        System.out.print(min);
    }
}
