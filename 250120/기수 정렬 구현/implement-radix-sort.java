import java.util.*;

public class Main {
    public static int[] radix(int[] lst, int k) {
        int n = lst.length;

        for (int i = 0; i < k; i++) {
            Queue<Integer>[] num = new LinkedList[10];
            for (int d = 0; d < 10; d++) {
                num[d] = new LinkedList<>();
            }

            // 자릿수별로 분배
            for (int j = 0; j < n; j++) {
                int digit = (lst[j] / (int) Math.pow(10, i)) % 10;
                num[digit].offer(lst[j]);
            }

            // 새로운 배열로 재구성
            int cnt = 0;
            for (int d = 0; d < 10; d++) {
                while (!num[d].isEmpty()) {
                    lst[cnt++] = num[d].poll();
                }
            }
        }

        return lst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();

        int max = Arrays.stream(lst).max().getAsInt();
        String tmp = Integer.toString(max);
        int k = tmp.length();

        int[] res = radix(lst, k);
        for (int i = 0; i < n; i++)
            System.out.print(res[i] + " ");
    }
}