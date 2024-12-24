import java.util.*;

public class Main {
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
        int[] lst = new int[2001];
        sc.nextLine();

        List<Word> command = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String tmp = sc.nextLine().trim();
            int cnt = Integer.parseInt(tmp.split(" ")[0]);
            String way = tmp.split(" ")[1];
            Word word = new Word(cnt, way);
            command.add(word);
        }

        int idx = 1000;
        int tmp_way = 0;

        for (Word word : command){
            if (word.way == 1){
                if (tmp_way == -1)
                    idx++;
                for (int i = 0; i < word.cnt; i++){
                    // System.out.println("R " + idx);
                    lst[idx]++;
                    idx++;
                }
                tmp_way = 1;
            }else{
                if (tmp_way == 1)
                    idx--;
                for (int i = 0; i < word.cnt; i++){
                    // System.out.println("L " + idx);
                    lst[idx]++;
                    idx--;
                }
                tmp_way = -1;
            }
            // System.out.println(idx);
        }
        idx = 0;
        for (int i = 0; i < 2001; i++){
            if (lst[i] > 1)
                idx++;
        }
        System.out.print(idx);
    }
}