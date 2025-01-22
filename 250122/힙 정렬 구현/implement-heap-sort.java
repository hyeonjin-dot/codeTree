import java.util.*;

public class Main {
    public static void heapify(int[] lst, int n, int i) {
        int largest = i;         // 현재 노드
        int left = 2 * i + 1;    // 왼쪽 자식
        int right = 2 * i + 2;   // 오른쪽 자식

        // 왼쪽 자식이 더 크면 largest 갱신
        if (left < n && lst[left] > lst[largest]) {
            largest = left;
        }

        // 오른쪽 자식이 더 크면 largest 갱신
        if (right < n && lst[right] > lst[largest]) {
            largest = right;
        }

        // largest가 변경되었으면 교환 및 재귀적으로 힙화
        if (largest != i) {
            int temp = lst[i];
            lst[i] = lst[largest];
            lst[largest] = temp;

            // 재귀적으로 하위 트리를 힙화
            heapify(lst, n, largest);
        }
    }

    public static void heapSort(int[] lst) {
        int n = lst.length;

        // 힙 빌드: 최대 힙 생성
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(lst, n, i);
        }

        // 힙 정렬
        for (int i = n - 1; i > 0; i--) {
            // 루트(가장 큰 값)를 끝으로 보냄
            int temp = lst[0];
            lst[0] = lst[i];
            lst[i] = temp;

            // 나머지 힙화
            heapify(lst, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];

        for (int i = 0; i < n; i++) {
            lst[i] = sc.nextInt();
        }

        heapSort(lst);

        for (int i = 0; i < n; i++) {
            System.out.print(lst[i] + " ");
        }
    }
}
