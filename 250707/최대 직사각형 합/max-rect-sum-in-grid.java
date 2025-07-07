import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        // 입력 받기
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int max = Integer.MIN_VALUE;

        // 시작 행을 고정
        for (int row1 = 0; row1 < n; row1++) {
            // 끝 행을 고정
            int[] colSum = new int[n]; // 열별 누적합
            for (int row2 = row1; row2 < n; row2++) {
                // colSum 업데이트
                for (int col = 0; col < n; col++) {
                    colSum[col] += grid[row2][col];
                }

                // 누적합 배열에서 최대 연속 부분합 구하기 (Kadane’s Algorithm)
                int currentMax = kadane(colSum);
                max = Math.max(max, currentMax);
            }
        }

        System.out.println(max);
    }

    // 1차원 배열에서 최대 연속 부분합 구하는 함수
    public static int kadane(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
