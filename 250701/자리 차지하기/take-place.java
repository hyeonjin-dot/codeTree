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
            if (!s.contains(arr[i]))
                s.add(arr[i]);
            else {
                int tmp = arr[i];
                while (tmp > 0){
                    if (!s.contains(tmp)){
                        s.add(tmp);
                        break;
                    }
                    tmp--;
                }
                if (tmp == 0)
                    break ;
            }
        }

        System.out.print(s.size());
        // Please write your code here.
    }
}