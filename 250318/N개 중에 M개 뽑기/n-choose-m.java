import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static List<Integer> lst = new ArrayList<>();

    public static void find(int idx){
        if (idx == m){
            for (int i = 0; i < m; i++)
                System.out.print(lst.get(i) + " ");
            System.out.println();
            return ;
        }

        for (int i = 1; i <= n; i++){
            if (lst.contains(i) || (lst.size() > 0 && Collections.max(lst) > i))
                continue ;

            lst.add(i);
            find(idx + 1);
            lst.remove(lst.size() - 1);
        }
        return ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        find(0);
    }
}