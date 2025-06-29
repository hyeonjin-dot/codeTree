import java.util.*;
public class Main {
    public static HashSet<Integer> s = new HashSet<>();

    public static int howMany(int len, int[] arr){
        int cnt = 0;
        for (int i = 0; i < len; i++){
            if (s.contains(arr[i]))
                cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 최대 n명
        int g = sc.nextInt(); // 그룹 개수
        
        for (int i = 0; i < g; i++){
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++)
                arr[j] = sc.nextInt();
            
            s.add(arr[0]);

            // 몇명이 받았나요?
            if (howMany(len, arr) + 1 == len){
                // 없는 사람 추가
                for (int j = 0; j < len; j++){
                    if (!s.contains(arr[j]))
                        s.add(arr[j]);
                }
            }   
        }

        System.out.print(s.size());
    }
}