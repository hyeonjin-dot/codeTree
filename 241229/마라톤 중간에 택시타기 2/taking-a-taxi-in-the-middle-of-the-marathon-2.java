import java.util.*;

public class Main {
    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Point> checkPoint = new ArrayList<>();

        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point point = new Point(x, y);
            checkPoint.add(point);
        }

        int min = 90000001;
        for (int i = 1; i < n - 1; i++){
            int startX = checkPoint.get(0).getX();
            int startY = checkPoint.get(0).getY();
            int way = 0;
            for (int j = 1; j < n; j++){
                if (j == i)
                    continue;
                way += (Math.abs(startX - checkPoint.get(j).getX())
                + Math.abs(startY - checkPoint.get(j).getY()));
                startX = checkPoint.get(j).getX();
                startY = checkPoint.get(j).getY();
            }
            way += (Math.abs(startX - checkPoint.get(n - 1).getX())
                + Math.abs(startY - checkPoint.get(n - 1).getY()));
            min = min < way ? min : way;
        }

        System.out.print(min);
    }
}