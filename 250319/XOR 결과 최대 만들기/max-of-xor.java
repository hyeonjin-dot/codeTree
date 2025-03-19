import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[] A;
    public static List<Integer> lst = new ArrayList<>();
    public static int max;

    public static int findXor(){
        int res = lst.get(0);
        for (int i = 1; i < m; i++)
            res = res ^ lst.get(i);
        return res;
    }

    public static void find(int idx){
        if (lst.size() == m){
            max = Math.max(max, findXor());
            return ;
        }

        if (idx >= n){
            if (lst.size() == m)
                max = Math.max(max, findXor());
            return ;
        }

        // for (int i = idx; i < n; i++){
            lst.add(A[idx]);
            find(idx + 1);
            lst.remove(lst.size() - 1);
            find(idx + 1);
        // }

        return ;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        max = 0;
        find(0);
        System.out.print(max);
    }
}