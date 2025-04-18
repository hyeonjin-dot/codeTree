import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }

        int[] up = new int[n];

        for (int i = 0; i < n; i++){
            up[i] = 1;
            for (int j = 0; j < i; j++){
                // if (arr[i] != max){
                    if (arr[i] > arr[j])
                        up[i] = Math.max(up[i], up[j] + 1);
            }
        }

        int[] down = new int[n];
        
        for (int i = n - 1; i >= 0; i--){
            down[i] = 1;
            for (int j = n - 1; j > i; j--){
                if (arr[j] < arr[i])
                    down[i] = Math.max(down[i], down[j] + 1);
            }
        }

        for (int i = 0; i < n; i++)
            // System.out.print(down[i] + " ");
            up[i] += (down[i] - 1);

        Arrays.sort(up);
        System.out.print(up[n - 1]);
    }
}