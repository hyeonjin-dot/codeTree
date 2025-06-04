import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] A = new int[k];
        int[] B = new int[k];
        for (int i = 0; i < k; i++) {
            A[i] = sc.nextInt() - 1;
            B[i] = sc.nextInt() - 1;
        }

        int[] seat = new int[n];
        for (int i = 0; i < n; i++)
            seat[i] = i; // 사람 자리
        
        HashSet<Integer>[] visited = new HashSet[n];
        for (int i = 0; i < n; i++) {
            visited[i] = new HashSet<>(); // 사람 기준
            visited[i].add(i);
        }

        for (int round = 0; round < 3; round++){
            for (int i = 0; i < k; i++){
                int a = A[i];
                int b = B[i];

                int positionA = -1;
                int positionB = -1;
                for (int j = 0; j < n; j++){
                    if (seat[j] == a)
                        positionA = j;
                    if (seat[j] == b)
                        positionB = j;
                }

                int tmp = seat[positionA];
                seat[positionA] = seat[positionB];
                seat[positionB] = tmp;

                visited[positionA].add(seat[positionA]);
                visited[positionB].add(seat[positionB]);
            }
        }

        for (int i = 0; i < n; i++)
            System.out.println(visited[i].size());
    }
}