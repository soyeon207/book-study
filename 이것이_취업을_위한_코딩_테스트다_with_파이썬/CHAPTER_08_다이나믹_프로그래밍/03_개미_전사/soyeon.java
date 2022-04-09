import java.util.*;

public class Main {

    public static void main(String ars[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int food_arr[] = new int[N];

        for(int i=0; i<N;i++) {
            food_arr[i] = sc.nextInt();
        }

        int score[] = new int[N];
        score[0] = food_arr[0];
        score[1] = food_arr[1];
        score[2] = food_arr[2] + n[0];
        
        // DP 보텀업 방식 사용 
        // 처음부터 최대로 식량을 가질 수 있는 값을 구한다. 
        // 앞앞앞의 값 보다 앞앞의 값 중 더 큰 값을 더해줌. 
        for(int i=3;i<N;i++) {
            score[i] = n[i] + Math.max(score[i-3], score[i-2]);
        }

        System.out.println(Math.max(score[N-2], score[N-1]));
    }
    
}
