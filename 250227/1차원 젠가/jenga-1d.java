import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt() - 1;
        int e1 = sc.nextInt() - 1;
        int s2 = sc.nextInt() - 1;
        int e2 = sc.nextInt() - 1;

        int[] lst = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++){
            if (i >= s1 && i <= e1)
                continue;
            lst[idx++] = blocks[i];
        }

        int[] res = new int[n];
        idx = 0;
        for (int i = 0; i < n; i++){
            if (lst[i] == 0)
                break;
            if (i >= s2 && i <= e2)
                continue;
            res[idx++] = lst[i];
        }

        System.out.println(idx);
        idx = 0;
        while (res[idx] != 0)
            System.out.println(res[idx++]);

    }
}