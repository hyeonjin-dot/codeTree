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

        int max = 0;

        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    if ((lst[i] % 10) + (lst[j] % 10) +(lst[k] % 10) < 10){
                        if (lst[i] % 100 + lst[j] % 100 + lst[k] % 100 < 100){
                            if (lst[i] % 1000 + lst[j] % 1000 
                            + lst[k] % 1000 < 1000){
                                if (lst[i] % 10000 + lst[j] % 10000 
                            + lst[k] % 10000 < 10000){
                                int tmp = lst[i] + lst[j] + lst[k];
                                max = max > tmp ? max : tmp;
                            }
                            }
                        }
                    }
                }
            }
        }

        System.out.print(max);
    }
}