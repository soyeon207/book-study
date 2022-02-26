import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();           // 행의 개수 
        int M = sc.nextInt();           // 열의 개수 
        
        int num = 0;                    // 입력받을 수 
        int min = Integer.MAX_VALUE;    // 행에서 가장 작은 수를 구하기 위한 변수 
        int row_min = 0;                // 조건에 맞는 가장 작은 수를 구하기 위한 변수 
        
        for(int i = 0; i<N;i++) {
            min = Integer.MAX_VALUE;
            for(int j=0;j<M;j++) {
                num = sc.nextInt();
                if (num < min) min = num;
            }
            
            if (row_min < min) row_min = min;
        }
        
        
        System.out.println(row_min);
    }
}