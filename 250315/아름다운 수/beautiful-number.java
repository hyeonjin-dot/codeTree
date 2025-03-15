import java.util.*;
public class Main {
    public static int n;
    public static List<Integer> lst = new ArrayList<>();
    public static int res;

    public static void checkBeauty(){
        int len = lst.size();
        boolean vaild = false;

        for (int i = 0; i < len; i++){
            if (lst.get(i) == 1)
                vaild = true;
            else if (i < len - 1 && lst.get(i) == 2 && lst.get(i + 1) == 2){
                vaild = true;
                i += 1;
            }
            else if (i < len - 2 && lst.get(i) == 3 && lst.get(i + 1) == 3 
                && lst.get(i + 2) == 3){
                vaild = true;
                i += 2;
            }
            else if (i < len - 3 && lst.get(i) == 4 && lst.get(i + 1) == 4 
                && lst.get(i + 2) == 4 && lst.get(i + 3) == 4){
                vaild = true;
                i += 3;
            }
            else
                vaild = false;

            if (!vaild)
                break ;
        }

        if (vaild)
            res++;
    }

    public static void made(int num){
        if (num == n){
            checkBeauty();
            return ;
        }
        
        for (int i = 1; i <= 4; i++){
            lst.add(i);
            made(num + 1);
            lst.remove(lst.size() - 1);
        }
        return ;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int num = 0;
        res = 0;
        made(0);

        System.out.print(res);
    }
}