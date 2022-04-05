import java.util.Scanner;

class fibo {
    public static int fibo(int num) {
        if (num == 2 || num == 1) return 1;
        return fibo(num-1) + fibo(num-2);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int fibo_num = sc.nextInt();
        
        System.out.println(fibo(fibo_num));
    }
}