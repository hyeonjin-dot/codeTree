import java.util.*;

public class Main {
    public static TreeSet<int[]> s;

    public static void check(int num){
        int[] target = null;
        for (int[] tmp : s){
            if (tmp[0] <= num && num <= tmp[1]) {
                target = tmp;
                break;
            }
        }
        if (target == null) return;

        s.remove(target);

        if (target[0] <= num - 1)
            s.add(new int[]{target[0], num - 1, num - 1 - target[0] + 1});
        if (num + 1 <= target[1])
            s.add(new int[]{num + 1, target[1], target[1] - (num + 1) + 1});
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 전체 길이
        int m = sc.nextInt(); // 삭제 횟수
        s = new TreeSet<>((a,b) -> {
            if (a[2] != b[2]) return a[2] - b[2];       // 길이 우선
            if (a[0] != b[0]) return a[0] - b[0];       // 시작점
            return a[1] - b[1];
        });

        s.add(new int[]{0, n, n + 1});

        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            check(tmp);
            int[] res = s.last(); // 가장 긴 구간
            System.out.println(res[2]);
        }
    }
}
