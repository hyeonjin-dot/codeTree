import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] points;
    public static List<int[]> point = new ArrayList<>();
    public static int min;
    
    public static int findMax(){
        int ret = 0;
        for (int i = 0; i < m - 1; i++){
            for (int j = 1; j < m; j++){
                int tmp = (int)(Math.pow(point.get(i)[0] - point.get(j)[0], 2) 
                    + Math.pow(point.get(i)[1] - point.get(j)[1], 2));
                ret = Math.max(ret, tmp);
            }
        }

        return ret;
    }

    public static void find(int idx){
        if (idx == n){
            if (point.size() == m)
                min = Math.min(min, findMax());
            return ;
        }

        point.add(points[idx]);
        find(idx + 1);
        point.remove(point.size() - 1);
        find(idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        
        min = Integer.MAX_VALUE;

        find(0);
        System.out.print(min);
    }
}