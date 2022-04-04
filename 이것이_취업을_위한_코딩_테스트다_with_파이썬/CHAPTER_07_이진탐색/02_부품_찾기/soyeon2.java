import java.util.Scanner;
import java.util.Arrays;

class Main {
    
    public static int binarySerach(int[] arr, int target, int start, int end) {
        int mid = (start + end) / 2;
        
        if (start > end) return -1;
        if(arr[mid] == target) return mid + 1;
        else if (arr[mid] < target) return binarySerach(arr, target, mid+1, end);
        else return binarySerach(arr, target, start, mid-1); 
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int arr_n[] = new int[N];
        for(int i=0;i<N;i++) {
            arr_n[i] = sc.nextInt();
        }
        
        Arrays.sort(arr_n);
        
        int M = sc.nextInt();
        int mm;
        boolean isContain;
        for(int i=0;i<M;i++) {
            mm = sc.nextInt();
            isContain = binarySerach(arr_n, mm, 0, N-1) != -1 ;
            System.out.print(isContain ? "yes " : "no ");
        }
    }
}