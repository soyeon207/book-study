import java.util.Scanner;
import java.util.Arrays;

class soyeon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int rice[] = new int[N];
        
        for(int i=0;i<N;i++) {
            rice[i] = sc.nextInt();
        }
        
        Arrays.sort(rice);
        
        int height = 0, max = 0;
        while(height < M) {
            for(int i=N-1;i>=0;i--) {
                if (i==N-1) {
                    max = rice[i];
                    rice[i] = max - 1;
                    height++;
                } else if (max == rice[i]) {
                    rice[i] = max - 1;
                    height++;
                } else {
                    continue;
                }
            }
        }
        
        System.out.println(rice[N-1]);
    
    }
}