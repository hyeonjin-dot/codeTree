import java.util.*;

public class Main {
    public static TreeSet<int[]> s;
    public static TreeSet<Integer> removals;

    public static void check(int num){
        int[] target = null;
        for (int[] tmp : s){
            if (tmp[0] <= num && num <= tmp[1]) {
                target = tmp;
                break;
            }
        }
        if (target == null) return;

        s.remove(target); // 기존 범위 제거

        if (num == target[0]) {
            Integer next = removals.higher(num);
            if (next != null && next <= target[1]) {
                s.add(new int[]{next, target[1], target[1] - next + 1});
            }
        } else if (num == target[1]) {
            Integer prev = removals.lower(num);
            if (prev != null && prev >= target[0]) {
                s.add(new int[]{target[0], prev, prev - target[0] + 1});
            }
        } else {
            // 양쪽으로 나눔
            if (num - 1 >= target[0])
                s.add(new int[]{target[0], num - 1, num - 1 - target[0] + 1});
            if (num + 1 <= target[1])
                s.add(new int[]{num + 1, target[1], target[1] - (num + 1) + 1});
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        s = new TreeSet<>((a,b) -> {
            if (a[2] != b[2]) return a[2] - b[2];       // 길이 우선
            if (a[0] != b[0]) return a[0] - b[0];       // 시작점
            return a[1] - b[1];
        });

        s.add(new int[]{0, n, n + 1});

        // int[] removals = new int[m];
        removals = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            removals.add(tmp);
            check(tmp);
            if (s.isEmpty())
                s.add(new int[]{0, 0, 1});
            int[] res = s.last();
            System.out.println(res[2]);
        }
    
    }
}