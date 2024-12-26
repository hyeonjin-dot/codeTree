import java.util.*;

public class Main {
    public static int[] bl = new int[200001];
    public static int[] wh = new int[200001];
    public static int[] color = new int[200001];

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

        int n = Integer.parseInt(sc.nextLine().trim());

        List<Word> lst = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String tmp = sc.nextLine().trim();
            int cnt = Integer.parseInt(tmp.split(" ")[0]);
            String way = tmp.split(" ")[1];
            Word word = new Word(cnt, way);
            lst.add(word);
        }


        int idx = 100000;
        int tmp_way = 0;
        for (Word word : lst){
            if (tmp_way == 0){
                for (int i = 0; i < word.cnt; i++){
                    if (word.way == -1)
                        wh[idx]++;
                    else
                        bl[idx]++;
                    if(wh[idx] >= 2 && bl[idx] >= 2)
                        color[idx] = 0;
                    else
                        color[idx] = word.way;
                    idx += word.way;
                }
            }else {
                if (tmp_way != word.way)
                    idx += word.way;
                    for (int i = 0; i < word.cnt; i++){
                        if (word.way == -1)
                            wh[idx]++;
                        else
                            bl[idx]++;
                        if(wh[idx] >= 2 && bl[idx] >= 2)
                            color[idx] = 0;
                        else
                            color[idx] = word.way;
                        idx += word.way;
                    }
                
            }
            tmp_way = word.way;
        }

        int gray = 0;
        int black = 0;
        int white = 0;
        for (int i = 0; i < 200001; i++){
            if (wh[idx] >= 2 && bl[idx] >= 2)
                gray++;
            if (color[i] == 1)
                black++;
            else if (color[i] == -1)
                white++;
        }

        System.out.print(white + " " + black + " " + gray);
    }
}