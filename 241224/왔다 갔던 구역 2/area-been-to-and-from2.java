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
        for (Word word : command){
            if (word.way == 1){
                for (int i = 0; i < word.cnt; i++){
                    lst[idx]++;
                    idx++;
                }
            }else{
                for (int i = 0; i < word.cnt; i++){
                    lst[idx]++;
                    idx--;
                }
            }
        }
        idx = 0;
        for (int i = 0; i < 2001; i++){
            if (lst[i] >= 2)
                idx++;
        }
        System.out.print(idx);
    }
}