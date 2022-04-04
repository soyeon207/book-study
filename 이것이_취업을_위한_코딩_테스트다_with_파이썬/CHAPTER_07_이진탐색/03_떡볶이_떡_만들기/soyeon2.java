import java.util.Scanner;
import java.util.Arrays;

class soyeon2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int rice[] = new int[N];
        
        for(int i=0;i<N;i++) {
            rice[i] = sc.nextInt();
        }
        
        Arrays.sort(rice);
        
        int start = 0, end = rice[N-1], mid = 0, total = 0;
        
        while (start <= end) {
            mid = (start + end) / 2;
            total = 0;
            
            for (int i=0;i<N;i++) {
                if (rice[i] > mid) {
                    total += rice[i] - mid;
                }
            }
            
            if (M > total) {
                end = mid - 1;
            } else if (M < total) {
                start = mid + 1;
            } else {
                break;
            }
            
        }
        
        System.out.println(mid);
    
    }
}