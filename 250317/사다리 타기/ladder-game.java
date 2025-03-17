import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] ladder;
    public static int[] lst;
    public static int min;
    public static List<Integer> in = new ArrayList<>();

    public static void findResult(){
        for (int i = 0; i < n; i++){
            int move = i;
            int height = 0;
            while (height < m){
                if (ladder[move][height] != 0)
                    move++;
                else if (move != 0 && ladder[move - 1][height] != 0)
                    move--;
                height++;
            }
            lst[i] = move;
        }
    }

    public static boolean sameResult(){
        int[] tmp = new int[n];
        
        for (int i = 0; i < n; i++){
            int move = i;
            int height = 0;
            while (height < m){
                if (in.contains(ladder[move][height])){
                    move++;
                }else if (move > 0 && in.contains(ladder[move - 1][height]))
                    move--;
                
                height++;
            }
            tmp[i] = move;
        }
        
        for (int i = 0; i < n; i++){
            if (tmp[i] != lst[i])
                return false;
        }

        return true;
    }

    public static void findMin(int idx){
        if (sameResult()){
            min = Math.min(in.size(), min);
            return ;
        }

        if (idx == m + 1)
          return ;

        // idx 해당하는거 쓰기
        in.add(idx);
        findMin(idx + 1);
        // idx 해당하는거 안쓰기
        in.remove(in.size() - 1);
        findMin(idx + 1);

        return ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        ladder = new int[n][m];
        for(int i = 0; i < m; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            ladder[a][b] = i + 1;
        }

        lst = new int[n];
        findResult(); // 주어진 결과

        min = m;
        findMin(1);

        System.out.print(min);
    }
}