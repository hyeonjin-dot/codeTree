import java.util.*;

public class Main {
    public static int[] line = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            for (int j = start; j <= end; j++)
                line[j]++;
        }

        System.out.print(Arrays.stream(line).max().getAsInt());
    }
}