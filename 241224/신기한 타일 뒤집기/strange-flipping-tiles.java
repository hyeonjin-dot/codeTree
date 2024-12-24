import java.util.*;

public class Main {
    public static int black;
    public static int white;

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

        black = 0;
        white = 0;

        for (int i = 0; i < n; i++){
            if (i == 0){
                if (lst.get(i).way == 1)
                    black += lst.get(i).cnt;
                else
                    white += lst.get(i).cnt;
            } else if (lst.get(i).way == 1){
                black += lst.get(i).cnt;
                white -= lst.get(i).cnt;
            } else{
                white += lst.get(i).cnt;
                black -= lst.get(i).cnt;
            }

            black = Math.max(0, black);
            white = Math.max(0, white);

            if (i > 0 && lst.get(i).way == lst.get(i - 1).way){
                if (lst.get(i).way == 1)
                    black--;
                else
                    white--;
            }
        }

        System.out.print(white + " " + black);
    }
}