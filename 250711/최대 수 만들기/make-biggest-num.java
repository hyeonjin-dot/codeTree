import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().trim();
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        for (int i = 0; i < n; i++){
            System.out.print(arr[i]);
        }
    }
}