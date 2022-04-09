import java.util.*;

public class book {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int min_count[] = new int[x-1];

            

        // 다이나믹 프로그래밍(min_countynamic Programming) 진행(보텀업)
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
            min_count[i] = min_count[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) min_count[i] = Math.min(min_count[i], min_count[i / 2] + 1);
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) min_count[i] = Math.min(min_count[i], min_count[i / 3] + 1);
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0) min_count[i] = Math.min(min_count[i], min_count[i / 5] + 1);
        }

        System.out.println(min_count[x]);
    }
}