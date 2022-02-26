import java.util.Scanner;
import java.util.Arrays;

// 전혀 그리디 알고리즘을 이해하지 못하고 짠 쿼리 같음 
class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N,M,K;
        
        N = sc.nextInt(); // 배열의 크기 
        M = sc.nextInt(); // 숫자가 더해지는 횟수 
        K = sc.nextInt(); // 같은 인덱스가 연속해서 나올 수 있는 횟수 
        
        int arr[] = new int[N];
        
        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr); // arr 을 오름차순으로 정렬 
        
        int count = 1;  // 같은 인덱스를 연속적으로 더한 횟수 
        int max = 0;    // 총 더한 값 
        
        for(int i=0;i<M;i++) {
            max += arr[arr.length-1];
            
            if (count++ == K) {
                // 만약 K 만큼 같은 인덱스를 연속적으로 더한 경우 
                // 두번째로 큰 값을 더해줌 
                max += arr[arr.length-2];
                i++;
                count = 1;
            }
        }

        System.out.println(max);

    }
}