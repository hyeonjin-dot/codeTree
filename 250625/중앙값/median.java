import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            int m = sc.nextInt();
            int[] arr = new int[m];
            for(int i = 0; i < m; i++){
                arr[i] = sc.nextInt();
                q.add(arr[i]);
                if (i % 2 == 0){
                    int tmp = i / 2;
                    PriorityQueue<Integer> qq = new PriorityQueue<>(Collections.reverseOrder());
                    for (int j = 0; j <= tmp; j++)
                        qq.add(q.poll());
                    System.out.print(qq.peek() + " ");
                    while (qq.size() > 0)
                        q.add(qq.poll());
                }
            }
            System.out.println();
        }
    }
}