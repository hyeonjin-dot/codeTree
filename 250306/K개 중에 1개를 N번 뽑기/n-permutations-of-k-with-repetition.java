import java.util.*;

public class Main {
    public static int k;
    public static int n;
    public static List<Integer> print = new ArrayList<>();

    public static void find_print(int idx){
        if (idx == n){
            for (int i = 0; i < n; i++)
                System.out.print(print.get(i) + " ");
            System.out.println();
            return ;
        }

        for (int select = 1; select <= k; select++) {
            print.add(select);
            find_print(idx + 1);
            print.remove(print.size() - 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt(); // k 까지
        n = sc.nextInt(); // n번 뽑기

        find_print(0);
    }
}