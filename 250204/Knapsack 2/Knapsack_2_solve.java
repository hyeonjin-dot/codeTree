package java_algo;

import java.util.*;

public class dp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] input = new int[10][2]; // 무게, 가격

        for (int i = 0; i < 10; i++){
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
        }
        
        int[][] dp = new int[10][21];
        
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 21; j++){
                if (i == 0) { 
                    // 첫 번째 아이템만 고려하는 경우
                    if (j == input[i][0]) 
                        dp[i][j] = input[i][1]; 
                } else {
                    // 이전 아이템을 포함한 경우
                    dp[i][j] = dp[i - 1][j];

                    // 현재 아이템을 넣을 수 있는 경우
                    if (j - input[i][0] >= 0) 
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - input[i][0]] + input[i][1]);
                }
    
            }
        }
    }
}
