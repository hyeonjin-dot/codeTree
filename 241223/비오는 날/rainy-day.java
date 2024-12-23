import java.util.*;

public class Main {
    private static List<Info> lst = new ArrayList<>();


    public static class Info{
        public int year;
        public int mon;
        public int date;
        public String day;
        public String weather;

        public Info(int year, int mon,int date,
                         String day, String weather){
            this.year = year;
            this.mon = mon;
            this.date = date;
            this.day = day;
            this.weather = weather;
        }
    }

    public static void input(String tmp){
        int year = Integer.parseInt(tmp.substring(0, 4));
        int mon = Integer.parseInt(tmp.substring(5, 7));
        int date = Integer.parseInt(tmp.substring(8, 10));
        String day = tmp.substring(11, 14);
        String weather = tmp.substring(15);

        if (!weather.equals("Rain"))
            return ;

        Info info = new Info(year, mon, date, day, weather);
        lst.add(info);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0 ; i < len; i++){
            String tmp = sc.nextLine().trim();
            input(tmp);
        }

        Collections.sort(lst, Comparator
                        .comparingInt((Info info)->info.year)
                        .thenComparingInt((Info info)->info.mon)
                        .thenComparingInt((Info info)->info.date));

        StringBuilder printMon = new StringBuilder();
        if (lst.get(0).mon < 10)
            printMon.append("0");
        printMon.append(Integer.toString(lst.get(0).mon));
        StringBuilder printDate = new StringBuilder();
        if (lst.get(0).date < 10)
            printDate.append("0");
        printDate.append(Integer.toString(lst.get(0).date));

          
        System.out.print(lst.get(0).year + "-" + printMon.toString() + "-" + 
                    printDate.toString() + " " 
                    + lst.get(0).day + " "+ lst.get(0).weather);
    }
}