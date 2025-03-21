import java.util.*;

public class Main {
    public static int n;
    public static int[] visited;
    public static int[][] cost;
    public static int min;

    public static boolean allVisited(){
        for (int i = 0; i < n; i++){
            if (visited[i] == 0)
                return false;
        }
        return true;
    }

    public static boolean notVisitedOne(){
        boolean vaild = true;

        if (visited[0] != 0)
            vaild = false;

        for (int i = 1; i < n; i++){
            if (visited[i] == 0)
                vaild = false;
        }

        return vaild;
    }

    public static void find(int idx, int sum){
        if (allVisited()){
            min = Math.min(min, sum);
            return ;
        }

        for (int i = 0; i < n; i++){
            if (visited[i] > 0)
                continue ;

            if (cost[idx - 1][i] == 0)
                continue;

            if (!notVisitedOne() && i == 0)
                continue ;

            visited[i] = idx;
            find(i + 1, sum + cost[idx - 1][i]);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        
        visited = new int[n];
        min = Integer.MAX_VALUE;
        find(1, 0);
        System.out.print(min);
    }
}
