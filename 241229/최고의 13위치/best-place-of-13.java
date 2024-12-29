import java.util.*;

public class Main {
    public static int[][] lst;
    public static List<Integer> sum = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        lst = new int[n][n];

        for (int i = 0 ; i < n ; i++){
            for (int j = 0; j < n; j++){
                int tmp = sc.nextInt();
                lst[i][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - 2; j++){
                int tmp = lst[i][j] + lst[i][j + 1] + lst[i][j + 2];
                sum.add(tmp);
            }
        }

        Collections.sort(sum, Collections.reverseOrder());
        System.out.print(sum.get(0));
    }
}