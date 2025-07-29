import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int left = 0;
            int right = n - 1;
            int found = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == x) {
                    found = mid + 1; // 1-based index
                    break;
                } else if (arr[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(found);
        }
    }
}