import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String input = sc.nextLine().trim();
        int[] seat = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int before = 0;
        for (int i = 0; i < n; i++){
            seat[i] = (int)(input.charAt(i) - '0');
            if (i > 0 && input.charAt(i) == '1'){
                min = Math.min(min, i - before);
                max = Math.max(max, i - before);
                before = i;
            }
        }

        min = Math.min(max / 2, min);
        System.out.print(min);
        
        
    }
}

/*
10010001

*/