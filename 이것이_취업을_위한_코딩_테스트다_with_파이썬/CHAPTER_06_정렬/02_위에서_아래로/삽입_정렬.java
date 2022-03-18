import java.util.Scanner;

// 삽입 정렬을 사용한 풀이 방식 
class 삽입_정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 수열에 속해 있는 수의 개수 
        int arr[] = new int[N];
        
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }
        
        int temp;     
        for(int i=N-1;i>=0;i--) {
            for(int j=N-1;j>=i;j--) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        for(int a:arr) {
            System.out.print(a+" ");
        }
        
    }
}