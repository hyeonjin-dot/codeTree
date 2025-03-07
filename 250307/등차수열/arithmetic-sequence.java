import java.util.*;

public class Main {
    public static List<Integer> arr = new ArrayList<>();
    public static int n;

    public static int moreIdx(int target){
        for (int i = 0; i < n; i++){
            if (arr.get(i) > target)
                return i;
        }

        return -1;
    }

    public static int lessIdx(int target){
        for (int i = n - 1; i >= 0; i--){
            if (arr.get(i) < target)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            arr.add(tmp);
        }

        Collections.sort(arr);
        
        int res = 0;

        for (int i = arr.get(0) + 1; i < arr.get(n - 1); i++){
            if (arr.contains(i))
                continue;
            int cnt = 0;
            for (int j = 0; j <= lessIdx(i); j++){
                int diff = i - arr.get(j);
                for (int k = moreIdx(i); k < n; k++){
                    if (diff == (arr.get(k) - i))
                        cnt++;
                }
            }

            res = Math.max(cnt, res);
        }

        System.out.print(res);
    }
}