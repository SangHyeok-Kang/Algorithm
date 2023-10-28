import java.io.*;

/**
 * 문제번호 : 19532 문제 명 : 수학은 비대면 강의입니다
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a, b, c, d, e, f;
        int x = 0, y = 0;

        String[] s = br.readLine().split(" ");

        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);
        d = Integer.parseInt(s[3]);
        e = Integer.parseInt(s[4]);
        f = Integer.parseInt(s[5]);

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if (a * i + b * j == c && d * i + e * j == f) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        System.out.println(x + " " + y);
    }

}
