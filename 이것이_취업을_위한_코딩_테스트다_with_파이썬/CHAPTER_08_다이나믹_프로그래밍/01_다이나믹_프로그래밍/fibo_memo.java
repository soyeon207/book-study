import java.util.Scanner;
import java.util.Arrays;

class fibo_memo {
    static long memo_num[] = new long[100];
    
    public static long fibo(int num) {
        if (num == 2 || num == 1) return 1;
        
        if (memo_num[num] == 0) {
            // 0 인 경우 아직 메모이제이션 된 값이 없기 떄문에 
            // 해당 배열에 값을 넣어준다. 
            memo_num[num] = fibo(num - 1) + fibo(num -2);
        }
        
        return memo_num[num];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fibo_num = sc.nextInt();
        System.out.println(fibo(fibo_num));
    }
}