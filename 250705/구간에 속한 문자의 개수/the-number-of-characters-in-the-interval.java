import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next();
        }
        int[] r1 = new int[k];
        int[] c1 = new int[k];
        int[] r2 = new int[k];
        int[] c2 = new int[k];
        for (int i = 0; i < k; i++) {
            r1[i] = sc.nextInt() - 1;
            c1[i] = sc.nextInt() - 1;
            r2[i] = sc.nextInt() - 1;
            c2[i] = sc.nextInt() - 1;
        }
        

        for (int i = 0; i < k; i++){
            int a = 0;
            int b = 0;
            int c = 0;
            for (int x = r1[i]; x <= r2[i]; x++){
                for (int y = c1[i]; y <= c2[i]; y++){
                    if (grid[x].charAt(y) == 'a')
                        a++;
                    else if (grid[x].charAt(y) == 'b')
                        b++;
                    else
                        c++;
                }
            }
            System.out.println(a + " " + b + " " + c);
        }
    }
}