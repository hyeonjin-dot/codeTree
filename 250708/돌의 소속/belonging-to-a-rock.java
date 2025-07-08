import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] stones = new int[n + 1];
        int[] one = new int[n + 1];
        int[] two = new int[n + 1];
        int[] three = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stones[i] = sc.nextInt();
            if (stones[i] == 1)
                one[i]++;
            else if (stones[i] == 2)
                two[i]++;
            else 
                three[i]++;
            
            one[i] += one[i - 1];
            two[i] += two[i - 1];
            three[i] += three[i - 1];
        }
        int[] a = new int[q + 1];
        int[] b = new int[q + 1];
        for (int i = 1; i < q + 1; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            System.out.print(one[b[i]] - one[a[i] - 1] + " ");
            System.out.print(two[b[i]] - two[a[i] - 1] + " ");
            System.out.println(three[b[i]] - three[a[i] - 1] + " ");
        }
        // Please write your code here.
    }
}