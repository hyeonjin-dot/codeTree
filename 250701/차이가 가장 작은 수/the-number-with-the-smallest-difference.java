import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            s.add(arr[i]);
        }

        if (s.last() - s.first() < m){
            System.out.print(-1);
            return ;
        }
        
        int min = s.first();
        for (int num : s){
            if (num - min >= m){
                System.out.print(num - min);
                return ;
            }
        }
        

    }
}