import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int del = sc.nextInt();

        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++)
            que.add(i + 1);

        int cnt = 1;
        while (que.size() > 0){
            if (cnt == del){
                System.out.print(que.poll() + " ");
                cnt = 0;
            }else
                que.add(que.poll());
            cnt++;
        }
    }
}