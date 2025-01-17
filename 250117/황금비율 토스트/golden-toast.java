import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 StringBuilder 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 초기 문자열 길이
        int m = Integer.parseInt(st.nextToken()); // 명령어 개수

        StringBuilder sb = new StringBuilder(br.readLine()); // 초기 문자열
        int cursor = n; // 초기 커서는 문자열 끝

        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            char action = command.charAt(0);

            switch (action) {
                case 'L': // 커서를 왼쪽으로 이동
                    if (cursor > 0) cursor--;
                    break;
                case 'R': // 커서를 오른쪽으로 이동
                    if (cursor < sb.length()) cursor++;
                    break;
                case 'D': // 현재 커서 위치의 문자 삭제
                    if (cursor < sb.length()) sb.deleteCharAt(cursor);
                    break;
                case 'P': // 현재 커서 위치에 문자 삽입
                    char c = command.split(" ")[1].charAt(0);
                    sb.insert(cursor, c);
                    cursor++;
                    break;
            }
        }

        // 최종 결과 출력
        System.out.print(sb);
    }
}
