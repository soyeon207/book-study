import java.util.Scanner;

class 계수_정렬 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int arr[] = new int[N];
        
        int num_arr[] = new int[100001];
        
        int num;
        
        for(int i=0; i < N;i++) {
            num = sc.nextInt();
            num_arr[num] = 100;
        }
        
        for(int i=100000;i>=1;i--) {
            if (num_arr[i] == 100) {
                System.out.println(i);
            }
        }
        
        
    }
}