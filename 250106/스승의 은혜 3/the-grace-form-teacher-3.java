import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int money = sc.nextInt();

        int[][] lst = new int[n][3];

        for (int i = 0; i < n; i++) {
            lst[i][0] = sc.nextInt(); // 원래 가격
            lst[i][1] = sc.nextInt(); // 추가 비용
            lst[i][2] = lst[i][0] + lst[i][1]; // 총 비용
        }

        // 총 비용 기준 오름차순 정렬
        Arrays.sort(lst, (a, b) -> Integer.compare(a[2], b[2]));

        int maxCount = 0;

        // 모든 아이템에 대해 한 번씩 할인 적용
        for (int i = 0; i < n; i++) {
            int remainingMoney = money - (lst[i][0] / 2 + lst[i][1]); // i번 아이템 할인 적용
            if (remainingMoney < 0) continue; // 할인 적용해도 예산 초과 시 건너뜀

            int count = 1; // 할인 적용한 아이템 포함
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // 할인 적용한 아이템은 제외
                if (remainingMoney >= lst[j][2]) {
                    remainingMoney -= lst[j][2];
                    count++;
                } else {
                    break;
                }
            }
            maxCount = Math.max(maxCount, count); // 최대 구매 가능 개수 갱신
        }

        System.out.println(maxCount);
    }
}
