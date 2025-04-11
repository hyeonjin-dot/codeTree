import java.util.*;

public class Main {
    public static int n;
    public static Queue<int[]> q = new LinkedList<>();
    public static Set<Integer> set = new HashSet<>();

    public static int calculation(int idx, int n){
        if (idx == 0)
            return n - 1;
        else if (idx == 1)
            return n + 1;
        else if (idx == 2 && n % 2 == 0)
            return n / 2;
        else if (idx == 3 && n % 3 == 0)
            return n / 3;
        return n;
    }

    public static int dfs(){
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int move = tmp[1];

            if (x == 1)
                return move;
            
            for (int i = 0; i < 4; i++){
                int nx = calculation(i, x);
                if (nx == n || set.contains(nx))
                    continue;
                set.add(nx);
                q.add(new int[]{nx, move + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        q.add(new int[]{n, 0});
        set.add(n);
        System.out.print(dfs());
        
    }
}