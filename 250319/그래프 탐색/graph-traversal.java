import java.util.Scanner;
public class Main {
    public static int n;
    public static int m;
    public static int[] u; // 여기서
    public static int[] v; // 여기루
    public static boolean[] visited;
    public static int cnt;

    public static void dfs(int start){
        if (visited[start])
            return ;

        visited[start] = true;

        for (int i = 0; i < m; i++){
            if (u[i] == start){
                dfs(v[i]);
            }else if (v[i] == start){
                dfs(u[i]);
            }
        }

        return ;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        u = new int[m]; 
        v = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        
        visited = new boolean[n + 1];
        cnt = 0;
        dfs(1);

        for (int i = 2; i <= n; i++){
            if (visited[i])
                cnt++;
        }

        System.out.print(cnt);
    }
}