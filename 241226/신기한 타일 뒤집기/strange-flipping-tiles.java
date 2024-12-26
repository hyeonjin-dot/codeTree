import java.util.*;

public class Main {
    public static int[] tile = new int[2000001];

    public static class Word{
        int cnt;
        int way;

        public Word(int cnt, String s){
            this.cnt = cnt;
            if (s.equals("L"))
                this.way = -1;
            else
                this.way = 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<Word> lst = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String tmp = sc.nextLine().trim();
            int cnt = Integer.parseInt(tmp.split(" ")[0]);
            String way = tmp.split(" ")[1];
            Word word = new Word(cnt, way);
            lst.add(word);
        }

        int idx = 10000;
        for (Word word : lst){
            for (int i = 0; i < word.cnt; i++){
                tile[idx] = word.way;
                if (i < word.cnt - 1)
                    idx += word.way;
            }
        }
        

        int white = 0;
        int black = 0;

        for (int i = 0; i < 20001; i++){
            if (tile[i] == -1)
                white++;
            else if (tile[i] == 1)
                black++;
        }

        System.out.print(white + " " + black);
    }
}