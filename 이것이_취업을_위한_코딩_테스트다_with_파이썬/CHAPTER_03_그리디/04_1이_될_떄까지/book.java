import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        // N이 K 이상이라면 K로 계속 나누기
        while(n >= k) {
            // N이 K로 나누어 떨어지지 않는다면 N에서 1씩 빼기
            while (n % k != 0) {
                n--;
                result++;
            }

            // K로 나누기
            n/=k;
            result++;
        }

        // 마지막 남은 수에 대하여 1씩 뺴기 
        while(n>1) {
            n--;
            result++;
        }
        
        System.out.println(result);
    }

}