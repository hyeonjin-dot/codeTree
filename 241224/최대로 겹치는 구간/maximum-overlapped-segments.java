import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] line = new int[201];

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            int start = sc.nextInt() + 100;
            int end = sc.nextInt() + 100;

            for (int j = start; j <= end; j++)
                line[j]++;
        }

        System.out.print(Arrays.stream(line).max().getAsInt());
    }
}