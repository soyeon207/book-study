import java.util.Scanner;

class soyeon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int money[] = new int[N];
        int count[] = new int[M+1];
        for(int i=0;i<N;i++) {
            money[i] = sc.nextInt();
        }
        
        int n = 0;
        for(int i=1;i<=M;i++) {
            n = 0;
            for(int j=0;j<N;j++) {
            // for(int j=N-1;j>=0;j--) {
                if (i == money[j]) {
                     n = 1;
                    break;
                } else if (i < money[j]) {
                    n = -1;
                } else if ((n == 0 || n == -1 || count[i - money[j]] + 1 < n) && count[i - money[j]] != -1)  {
                    n = count[i - money[j]] + 1;
                    break;
                }
            }
            
            count[i] = n;
        }
        
        // for(int i=1;i<=M;i++) {
        //     System.out.println(count[i]);
        // }
        
        System.out.println(count[M]);
        
    }
}