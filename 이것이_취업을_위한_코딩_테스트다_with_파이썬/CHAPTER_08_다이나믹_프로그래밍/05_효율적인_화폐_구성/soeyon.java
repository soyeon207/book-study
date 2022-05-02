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
            for(int j=0;j<N;j++) {
                if (i < money[j] || i - money[j] < 0) {
                    n = -1;
                    continue;
                } else if (i == money[j]) {
                    n = 1;
                    continue;
                } else if (n == 0 || count[i - money[j]] < n)  {
                    n = count[i - money[j]] + 1;
                }
            }
            
            count[i] = n;
        }
        
        for(int c:count) {
            System.out.println(c);
        }
        
        System.out.println(count[M]);
    }
}