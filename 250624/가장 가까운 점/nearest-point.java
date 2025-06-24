import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] points = new int[n][3];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            points[i][2] = points[i][0] + points[i][1];
            q.add(points[i][2]);
        }

        for (int i = 0; i < m; i++){
            int min = q.poll();
            for (int j = 0; j < m; j++){
                if (points[j][2] == min){
                    points[j][0] += 2;
                    points[j][1] += 2;
                    points[j][2] += 4;
                    q.add(points[j][2]);
                    break ;
                }
            }
        }
        
        int min = q.poll();
        for (int i = 0; i < n; i++){
            if (points[i][2] == min){
                System.out.print(points[i][0] + " " + points[i][1]);
                return ;
            }
        }
    }
}