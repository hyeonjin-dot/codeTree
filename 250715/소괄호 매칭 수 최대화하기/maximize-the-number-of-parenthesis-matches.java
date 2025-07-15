import java.util.*;

class bck {
    String s;
    int open, close;

    public bck(String s){
        this.s = s;
        int openCnt = 0;
        int closeCnt = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                openCnt++;
            else
                closeCnt++;
        }
        this.open = openCnt;
        this.close = closeCnt;
    }

    public int getClose(){
        return this.close;
    }

    public int getOpen(){
        return this.open;
    }

    public String getS(){
        return this.s;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        bck[] lst = new bck[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            lst[i] = new bck(arr[i]);
        }

        Arrays.sort(lst, (a, b) -> a.getClose() * b.getOpen() - a.getOpen() * b.getClose());

        StringBuilder sb = new StringBuilder();
        for (bck str : lst)
            sb.append(str.getS());

        long cnt = 0;
        long back = 0;
        for (int i = sb.length() - 1; i >= 0; i--){
            if (sb.charAt(i) == '(')
                cnt += back;
            else
                back++;
        }

        System.out.print(cnt);
    }
}