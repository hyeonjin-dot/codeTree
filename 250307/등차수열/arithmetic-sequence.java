import java.util.*;

public class Main {
    public static List<Integer> arr = new ArrayList<>();
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            arr.add(tmp);
        }

        Collections.sort(arr);
        
        int res = 0;

        for (int i = 0; i <= 101; i++){
            int cnt = 0;

            for (int x = 0; x < n; x++){
                for (int y = x + 1; y < n; y++){
                    if (i - arr.get(x) == arr.get(y) - i)
                        cnt++;
                }
            }

            res = Math.max(cnt, res);
        }

        System.out.print(res);
    }
}