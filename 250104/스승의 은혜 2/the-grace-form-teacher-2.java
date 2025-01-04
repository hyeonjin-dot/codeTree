import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();

        Arrays.sort(lst);

        int sum = 0;
        int idx = -1;
        boolean used = false;
        while (idx < n - 1 && sum <= b){
            idx++;
            if (sum + lst[idx] > b && !used){
                used = true;
                sum += lst[idx] / 2 ;
            }else
                sum += lst[idx];
        }

        System.out.print(idx);
    }
}