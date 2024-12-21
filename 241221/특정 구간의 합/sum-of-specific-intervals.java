import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            lst.add(tmp);
        }

        for (int i = 0; i < m; i++){
            int a1 = sc.nextInt() - 1;
            int a2 = sc.nextInt();
            int sum = 0;
            for (int j = a1; j < a2; j++)
                sum += lst.get(j);
            System.out.println(sum);
        }
    }
}