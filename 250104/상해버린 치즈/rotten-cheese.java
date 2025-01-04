import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int s = sc.nextInt();

        int[][] taken = new int[n][m]; // n번 사람이 m번 치즈를 몇 초에 먹었는지
        int[] ill = new int[n];       // n번째 사람이 언제 아프기 시작했는지 
        boolean[] medicine = new boolean[n]; // 약 먹어야 하면 true
        Set<Integer> suspectCheese = new HashSet<>(); // 의심 치즈 후보

        // 사람들이 먹은 치즈 기록
        for (int i = 0; i < d; i++) {
            int person = sc.nextInt() - 1;
            int cheese = sc.nextInt() - 1;
            int when = sc.nextInt();
            taken[person][cheese] = when;
        }

        // 사람들이 아픈 시점 기록
        for (int i = 0; i < s; i++) {
            int person = sc.nextInt() - 1;
            int start = sc.nextInt();
            ill[person] = start;
        }

        // 1. 의심 치즈 후보 식별
        for (int i = 0; i < n; i++) {
            if (ill[i] == 0) continue; // 아프지 않은 사람 제외
            for (int j = 0; j < m; j++) {
                if (taken[i][j] > 0 && taken[i][j] < ill[i]) { 
                    suspectCheese.add(j); // 아프기 전에 먹은 치즈 추가
                }
            }
        }

        // 2. 의심 치즈 교차 검증
        Set<Integer> spoiledCheese = new HashSet<>(suspectCheese); // 상한 치즈 후보 초기화
        for (int i = 0; i < n; i++) {
            if (ill[i] == 0) continue; // 아프지 않은 사람 제외
            Set<Integer> currentSuspect = new HashSet<>();
            for (int j : suspectCheese) {
                if (taken[i][j] > 0 && taken[i][j] < ill[i]) {
                    currentSuspect.add(j); // 해당 사람이 아프기 전에 먹은 치즈만 남김
                }
            }
            spoiledCheese.retainAll(currentSuspect); // 교차 검증
        }

        // 3. 약 복용자 식별
        for (int cheese : spoiledCheese) {
            for (int i = 0; i < n; i++) {
                if (taken[i][cheese] > 0) {
                    medicine[i] = true; // 상한 치즈를 먹은 사람은 약 복용
                }
            }
        }

        // 약 복용자 수 계산
        int res = 0;
        for (boolean medi : medicine) {
            if (medi) res++;
        }

        System.out.print(res);
    }
}
