import java.util.*;
public class Main {
    public static int k;
    public static int n;
    public static List<Integer> lst = new ArrayList<>();

    public static void find(int idx){
        if (idx == n){
            for (int i = 0; i < n; i++)
                System.out.print(lst.get(i) + " ");
            System.out.println();
            return ;
        }

        for (int i = 1; i <= k; i++){
            if (lst.size() >= 2 && lst.get(lst.size() - 1) == i
                && lst.get(lst.size() - 1) == lst.get(lst.size() - 2))
                continue ;
            
            lst.add(i);
            find(idx + 1);
            lst.remove(lst.size() - 1);
        }
        return ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        
        find(0);
    }
}