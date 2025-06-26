import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] a = new int[3];
            a[0] = sc.nextInt();
            a[1] = sc.nextInt();
            a[2] = i;
            q.add(a);
        }
        
        int[] a = q.poll();
        int sum = a[0] + a[1];
        int max = 0;


        // sum보다  tmp[0]이 크면 sum 초기화
        while (q.size() > 0){
            List<int[]> lst = new ArrayList<>();
            while (true){
                if (q.isEmpty()) 
                    break; 
                int[] tmp = q.poll();
                if (tmp[0] > sum){
                    q.add(tmp);
                    break ;
                }
                lst.add(tmp);
            }
            
            int[] tmp;
            if (lst.size() > 0){
                Collections.sort(lst, Comparator.comparingInt(l -> l[2]));
                tmp = lst.get(0);
            } else {
                tmp = q.poll();
                sum = tmp[0];
            }

            max = Math.max(max, sum - tmp[0]);
            sum += tmp[1];

            for (int i = 1; i < lst.size(); i++)
                q.add(lst.get(i));
        }

        System.out.println(max);
    }
}