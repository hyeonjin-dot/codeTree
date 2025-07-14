import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt(); //red
        int n = sc.nextInt(); //black
        int[] redStones = new int[c];
        TreeSet<Integer> m = new TreeSet<>();
        for (int i = 0; i < c; i++) {
            redStones[i] = sc.nextInt();
            m.add(redStones[i]);
        }
        int[][] blackStones = new int[n][2];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            blackStones[i][0] = sc.nextInt();
            blackStones[i][1] = sc.nextInt();
            if (m.higher(blackStones[i][0]) != null 
                && m.ceiling(blackStones[i][1]) != null){
                    // if (m.higher(blackStones[i][0]) == m.ceiling(blackStones[i][1])){
                        // m.remove(m.higher(blackStones[i][0]));
                        cnt++;
                    // }
                }
        }

        System.out.print(cnt);
        // Please write your code here.
    }
}