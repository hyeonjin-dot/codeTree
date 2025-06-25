import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        // 출력할 값 이하값
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> max = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                int sum = arr1[i] + arr2[j];
                min.add(sum);

                // if (min.isEmpty() || sum <= min.peek())
                //     min.add(sum);
                // else
                //     max.add(sum);
                
                if (min.size() > k)
                    min.poll();
                    // max.add(min.poll());
            }
        }

        System.out.print(min.peek());
    }
}