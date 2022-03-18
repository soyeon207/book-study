import java.util.Scanner;

// 선택 정렬을 사용한 풀이 방식 
class 선택_정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 수열에 속해 있는 수의 개수 
        int arr[] = new int[N];
        
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }
        
        int min_index, temp;
        for(int i=0;i<N;i++) {
            min_index = i;
            for(int j=i+1;j<N;j++) {
                if(arr[min_index] < arr[j]) {
                    min_index = j;
                } 
            }
            
            temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        
        for(int a:arr) {
            System.out.print(a+" ");
        }
        
    }
}