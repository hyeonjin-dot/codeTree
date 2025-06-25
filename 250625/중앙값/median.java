import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int m = sc.nextInt();
            for(int i = 0; i < m; i++){
                int num = sc.nextInt();

                if (maxHeap.isEmpty() || num <= maxHeap.peek())
                    maxHeap.add(num);
                else
                    minHeap.add(num);
                
                if (maxHeap.size() > minHeap.size() + 1)
                    minHeap.add(maxHeap.poll());
                else if (minHeap.size() > maxHeap.size())
                    maxHeap.add(minHeap.poll());

                if (i % 2 == 0)
                    System.out.print(maxHeap.peek() + " ");
                
            }
            System.out.println();
        }
    }
}