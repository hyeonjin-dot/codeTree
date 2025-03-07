import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lst = new int[101];
        
        for (int i = 0; i < n; i++){
            int place = sc.nextInt();
            char input = sc.next().charAt(0);
            if (input == 'H')
                lst[place] = 1;
            else
                lst[place] = 2;
        }

        int max = 0;

        for (int i = 0; i < 101; i++){
            if (lst[i] > 0){
                int one = 0;
                int two = 0;
                for (int j = i; j < 101; j++){
                    if (lst[j] == 1)
                        one++;
                    else if (lst[j] == 2)
                        two++;

                    if (lst[j] > 0 && one == two)
                        max = Math.max(max, (j - i));
                    if (lst[j] > 0 && (one == 0 || two == 0))
                        max = Math.max(max, (j - i));
                }
            }
        }

        System.out.print(max);
    }
}