import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int count = N % K;
        N -= count;
        
        while(N>1) {
            N/=K;
            count++;
        }
        
        System.out.println(count);

    }
}