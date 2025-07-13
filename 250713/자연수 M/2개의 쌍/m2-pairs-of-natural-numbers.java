import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        int total = 0;
        int[][] lst = new int[n][2];
        for (int i = 0; i < n; i++) {
            lst[i][1] = sc.nextInt(); // cnt
            lst[i][0] = sc.nextInt(); // value
            total += lst[i][1];
        }

        Arrays.sort(lst, (a, b) -> Integer.compare(a[0], b[0]));

        int leftIdx = 0;
        int rightIdx = n - 1;
        int leftCnt = lst[leftIdx][1];
        int rightCnt = lst[rightIdx][1];
        int max = 0;
        for (int i = 0; i < total / 2; i++){
            int sum = lst[leftIdx][0] + lst[rightIdx][0];
            max = Math.max(max, sum);
            leftCnt--;
            rightCnt--;

            if (leftCnt == 0){
                leftIdx++;
                leftCnt = lst[leftIdx][1];
            }
            if (rightCnt == 0){
                rightIdx--;
                rightCnt = lst[rightIdx][1];
            }
        }

        System.out.println(max);
    }
}
