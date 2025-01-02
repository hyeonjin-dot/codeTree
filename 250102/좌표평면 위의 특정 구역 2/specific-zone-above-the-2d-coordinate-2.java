import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] lst = new int[n][2];

        for (int i = 0; i < n; i++){
            lst[i][0] = sc.nextInt();
            lst[i][1] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            List<int[]> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    temp.add(lst[j]);
                }
            }

            // X 좌표 정렬
            temp.sort(Comparator.comparingInt(a -> a[0]));
            int min_x = temp.get(0)[0];
            int max_x = temp.get(temp.size() - 1)[0];

            // Y 좌표 정렬
            temp.sort(Comparator.comparingInt(a -> a[1]));
            int min_y = temp.get(0)[1];
            int max_y = temp.get(temp.size() - 1)[1];

            // 영역 계산
            int area = (max_x - min_x) * (max_y - min_y);
            min = Math.min(min, area); // 최소값 갱신
        }

        System.out.print(min);
    }
}