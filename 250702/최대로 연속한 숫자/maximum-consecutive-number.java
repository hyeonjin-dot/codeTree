import java.util.*;

public class Main {
    public static TreeMap<Integer, int[]> segments = new TreeMap<>();

    public static void check(int num){
        // num 이하 중 가장 가까운 구간의 시작점 찾기
        Map.Entry<Integer, int[]> entry = segments.floorEntry(num);
        if (entry == null) return;
        int[] seg = entry.getValue();

        if (seg[1] < num) return; // num이 구간 안에 없으면 무시

        segments.remove(seg[0]); // 기존 구간 삭제

        // 왼쪽 구간
        if (seg[0] <= num - 1)
            segments.put(seg[0], new int[]{seg[0], num - 1});

        // 오른쪽 구간
        if (num + 1 <= seg[1])
            segments.put(num + 1, new int[]{num + 1, seg[1]});
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 전체 범위: 0 ~ n
        int m = sc.nextInt(); // 삭제 횟수

        segments.put(0, new int[]{0, n});

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            check(x);

            int maxLen = 0;
            for (int[] seg : segments.values()) {
                maxLen = Math.max(maxLen, seg[1] - seg[0] + 1);
            }
            System.out.println(maxLen);
        }
    }
}
