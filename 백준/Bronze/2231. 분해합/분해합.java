import java.io.*;

/**
 * 문제번호: 2231번 문제 명: 분해합
 */
public class Main {

    static int disassemble(int num) {
        int result = 0;
        for (int i = 0; i < num; i++) {           
            int number = i;
            int sum = 0;
            
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum + i == num) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int num = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        int result = disassemble(num);

        System.out.println(result);
    }

}