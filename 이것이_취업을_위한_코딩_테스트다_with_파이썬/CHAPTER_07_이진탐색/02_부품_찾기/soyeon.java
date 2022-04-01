import java.util.Scanner;
import java.util.Arrays;

class soyeon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int arr_n[] = new int[N];
        for(int i=0;i<N;i++) {
            arr_n[i] = sc.nextInt();
        }
        
        int M = sc.nextInt();
        int mm;
        boolean isContain;
        for(int i=0;i<M;i++) {
            mm = sc.nextInt();
            isContain = Arrays.binarySearch(arr_n, mm) != -1 ;
            System.out.print(isContain ? "yes " : "no ");
        }
    }
}