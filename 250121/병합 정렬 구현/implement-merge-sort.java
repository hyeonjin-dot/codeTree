import java.util.*;

public class Main {
    public static void merge(int[] lst, int low, int mid, int high) {
        int x = low;
        int y = mid + 1;
        int idx = 0;
        int[] res = new int[high - low + 1];

        // 병합 과정
        while (x <= mid && y <= high) {
            if (lst[x] <= lst[y]) {
                res[idx++] = lst[x++];
            } else {
                res[idx++] = lst[y++];
            }
        }

        // 남은 요소 병합
        while (x <= mid)
            res[idx++] = lst[x++];
        
        while (y <= high)
            res[idx++] = lst[y++];

        // 결과를 원본 배열에 복사
        for (int i = low; i <= high; i++) {
            lst[i] = res[i - low];
        }
    }

    public static void sort(int[] lst, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(lst, low, mid);        // 왼쪽 정렬
            sort(lst, mid + 1, high);  // 오른쪽 정렬
            merge(lst, low, mid, high); // 병합
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] lst = new int[n];

        for (int i = 0; i < n; i++)
            lst[i] = sc.nextInt();
        
        sort(lst, 0, n - 1);

        for (int i = 0; i < n; i++)
            System.out.print(lst[i] + " ");
    }
}
