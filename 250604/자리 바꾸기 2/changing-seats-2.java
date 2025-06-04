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
        
        int[] seat = new int[n]; // seat[i]: i번 자리에 앉아있는 사람
        int[] pos = new int[n];  // pos[i]: i번 사람이 앉아있는 자리

        for (int i = 0; i < n; i++) {
            seat[i] = i;
            pos[i] = i;
        }
        
        HashSet<Integer>[] visited = new HashSet[n];
        for (int i = 0; i < n; i++) {
            visited[i] = new HashSet<>(); // 사람 기준
            visited[i].add(i);
        }

        for (int i = 0; i < 3 * k; i++){
            int a = A[i % k];
            int b = B[i % k];

            int personA = seat[a];
            int personB = seat[b];

            // 자리 교환
            seat[a] = personB;
            seat[b] = personA;

            // 위치 갱신
            pos[personA] = b;
            pos[personB] = a;

            visited[personA].add(b);
            visited[personB].add(a);
        }
        
        for (int i = 0; i < n; i++)
            System.out.println(visited[i].size());
    }
}