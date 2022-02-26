import java.util.*;

// 책에서 제안하는 풀이 방법 1 
// 이것 역시 while 을 돌면서 가장 큰 값과 두번째로 큰 값을 
// 더하는 방식이다. 
class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N,M,K;
        
        N = sc.nextInt(); // 배열의 크기 
        M = sc.nextInt(); // 숫자가 더해지는 횟수 
        K = sc.nextInt(); // 같은 인덱스가 연속해서 나올 수 있는 횟수 
        
        int arr[] = new int[N];
        for(int i=0;i<N;i++) {
           arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[N - 1]; // 가장 큰 수
        int second = arr[N - 2]; // 두 번째로 큰 수
        int result = 0;

        while(true) {
            for(int i=0; i<K; i++) {
                if (M == 0) break;
                result += first;
                M-=1;
            }
            
            if (M==0) break;
            
            result += second;
            M-=1;
        }
        
        System.out.println(result);

    }
}
