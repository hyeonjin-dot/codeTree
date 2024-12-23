import java.util.*;

public class Main {
    public static List<Student> lst = new ArrayList<>();

    public static class Student{
        int height;
        int weight;
        int num;

        public Student(int height, int weight, int num){
            this.height = height;
            this.weight = weight;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 1;

        for (int i = 0; i < n; i++){
            int h = sc.nextInt();
            int w = sc.nextInt();
            w = w * -1;
            Student student = new Student(h, w, cnt);
            cnt++;
            lst.add(student);
        }

        Collections.sort(lst, Comparator
                .comparingInt((Student student)-> student.height)
                .thenComparingInt((Student student)-> student.weight));
        
        for (int i = 0; i < n; i++){
            System.out.println(lst.get(i).height + " "
                        + lst.get(i).weight * -1 + " " 
                        + lst.get(i).num);
        }
    }
}