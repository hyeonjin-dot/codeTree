import java.util.*;

public class Main {
    public static int[][] lst;
    public static int n;
    public static int m;

    public static boolean right(int r1, int c1, int r2, int c2,
                                int x1, int y1, int x2, int y2){
        if (x1 > r2 || x2 < r1 || y1 > c2 || y2 < c1)
            return true;
        return false;
    }

    public static int circulate(int r1, int c1, int r2, int c2){
        int sum = 0;

        for (int i = r1; i <= r2; i++){
            for (int j = c1; j <= c2; j++)
                sum += lst[i][j];
        }

        return sum;
    }

    public static int find_max(){
        int ret = Integer.MIN_VALUE;

        for (int r1 = 0; r1 < n; r1++){
            for (int c1 = 0; c1 < m; c1++){
                for (int r2 = r1; r2 < n; r2++){
                    for (int c2 = c1; c2 < m; c2++){
                        int firSum = circulate(r1, c1, r2, c2);

                        for (int x1 = 0; x1 < n; x1++){
                            for (int y1 = 0; y1 < m; y1++){
                                for (int x2 = x1; x2 < n; x2++){
                                    for (int y2 = y1; y2 < m; y2++){
                                        if (right(r1, c1, r2, c2, x1, y1, x2, y2)){
                                            int secSum = circulate(x1, y1, x2, y2);
                                            ret = Math.max(ret, firSum + secSum);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        return ret;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        lst = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                lst[i][j] = sc.nextInt();
        }

        int max_sum = find_max();

        System.out.print(max_sum);
    }
}


// 두개의 직사각형 만들기
// 기존 하나 최대 값 찾기 + 그 다음 최소 값 찾기 -> 안댈ㄹ거같음
// 직사각형 두개를 동시에 돌리기 -> ? 오..