import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] lst = new int[n][2];

        for (int i = 0; i < n; i++){
            lst[i][0] = sc.nextInt();
            lst[i][1] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    if (lst[i][0] == lst[j][0]){ // y축
                        if (lst[i][1] == lst[k][1]){ //x축
                            int tmp = Math.abs(lst[i][1] - lst[j][1]) 
                                * Math.abs(lst[i][0] - lst[k][0]);
                            max = Math.max(max, tmp);
                        }else if (lst[j][1] == lst[k][1]){
                            int tmp = Math.abs(lst[i][1] - lst[j][1]) 
                                * Math.abs(lst[j][0] - lst[k][0]);
                            max = Math.max(max, tmp);
                        }
                    }else if (lst[i][0] == lst[k][0]){ // y축
                        if (lst[j][1] == lst[k][1]){ //x축
                            int tmp = Math.abs(lst[k][1] - lst[i][1]) 
                                * Math.abs(lst[j][0] - lst[k][0]);
                            max = Math.max(max, tmp);
                        }else if (lst[j][1] == lst[i][1]){
                            int tmp = Math.abs(lst[i][1] - lst[k][1]) 
                                * Math.abs(lst[j][0] - lst[i][0]);
                            max = Math.max(max, tmp);
                        }
                    }else if (lst[j][0] == lst[k][0]){ // y축
                        if (lst[i][1] == lst[k][1]){ //x축
                            int tmp = Math.abs(lst[k][1] - lst[j][1]) 
                                * Math.abs(lst[i][0] - lst[k][0]);
                            max = Math.max(max, tmp);
                        }else if (lst[j][1] == lst[i][1]){
                            int tmp = Math.abs(lst[j][1] - lst[k][1]) 
                                * Math.abs(lst[j][0] - lst[i][0]);
                            max = Math.max(max, tmp);
                        }
                    }
                }
            }
        }

        if (max == Integer.MIN_VALUE)
            max = 0;
        System.out.print(max);
    }
}