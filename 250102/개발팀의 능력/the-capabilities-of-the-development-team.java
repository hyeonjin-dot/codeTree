import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] lst = new int[5];

        for (int i = 0; i < 5; i++)
            lst[i] = sc.nextInt();

        Arrays.sort(lst);

        int max = -1;

        int sum1 = lst[0] + lst[3];
        int sum2 = lst[1] + lst[2];
        int sum3 = lst[4];

        if (sum1 == sum2 || sum2 == sum3 || sum1 == sum3){
            sum1 = lst[0] + lst[2];
            sum2 = lst[1] + lst[3];
            if (sum1 == sum2 || sum2 == sum3 || sum1 == sum3){
                sum1 = lst[0] + lst[1];
                sum2 = lst[2] + lst[3];   
            }
        }

        max = Math.abs(sum1 - sum2) > Math.abs(sum1 - sum3) 
            ? Math.abs(sum1 - sum2) : Math.abs(sum1 - sum3);
        max = max > Math.abs(sum3 - sum2) ? max : Math.abs(sum3 - sum2);
        
        if (max == 0)
            max = -1;
        System.out.print(max);
    }
}