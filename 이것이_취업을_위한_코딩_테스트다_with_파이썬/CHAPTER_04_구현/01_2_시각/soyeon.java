import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int count = 0;
        for(int h = 0;h<=N;h++) {
            for(int m=0;m<=59;m++) {
                for(int s=0;s<=59;s++) {
                    if (h == 3 || (m % 10 == 3) || (m/10 == 3) || (s/10 == 3)|| (s % 10 == 3)) count++;
                }
            }
        }
        
        System.out.println(count);
    }
}