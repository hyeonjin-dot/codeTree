import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int money = sc.nextInt();

        int[][] lst = new int[n][3];

        for (int i = 0; i < n; i++) {
            lst[i][0] = sc.nextInt() / 2; // 가격
            lst[i][1] = sc.nextInt(); // 추가 비용
            lst[i][2] = lst[i][0] + lst[i][1]; // 총 비용
        }

        Arrays.sort(lst, (a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]); // 총 비용 기준 오름차순
            } else {
                return Integer.compare(b[0], a[0]); // 가격 기준 내림차순
            }
        });

        boolean usedDiscount = false; // 할인 사용 여부
        int sum = 0; // 현재 총 비용
        int count = 0; // 구매 가능한 아이템 개수

        for (int i = 0; i < n; i++) {
            int price = lst[i][0];
            int additionalCost = lst[i][1];
            int totalCost = price * 2 + additionalCost;

            if (!usedDiscount && sum + price + additionalCost <= money) {
                // 할인 적용 가능한 경우
                sum += (price / 2) + additionalCost;
                usedDiscount = true;
                count++;
            } else if (sum + totalCost <= money) {
                // 할인 없이 구매 가능한 경우
                sum += totalCost;
                count++;
            } else {
                // 더 이상 구매 불가
                break;
            }
        }

        System.out.println(count);
    }
}
