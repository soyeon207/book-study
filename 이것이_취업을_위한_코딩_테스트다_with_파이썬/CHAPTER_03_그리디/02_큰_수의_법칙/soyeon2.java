import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N,M,K;
        
        N = sc.nextInt(); // 입력받을 수의 개수 
        M = sc.nextInt(); // 숫자가 더해지는 횟수 
        K = sc.nextInt(); // 같은 인덱스가 연속해서 나올 수 있는 횟수 
        
        // 입력받을 수 만큼 반복문을 돌면서 입력을 받고 
        // 가장 큰 값과 두번째로 큰 값을 구한다. 
        int max_num = 0, second_max_num = 0, num;
        for(int i=0;i<N;i++) {
            num = sc.nextInt();
            if (max_num <= num) {
                second_max_num = max_num;
                max_num = num;
            }
        }

        int sum = 0; // 더한 값 
        while (M > 0) { // M 이 0 이 될 때까지 반복문을 돌고 

            // 만일 M 보다 K 가 작거나 같다면 두번째로 큰 값을 더해줄 필요가 없기 때문에 
            // 그냥 max_num x M 한 값을 더해준다. 
            if (M <= K) { 
                sum += (max_num * M);
                break;
            }
            
            // max_num * K 를 한 다음 같은 인덱스가 연속해서 나오면 안되기 때문에 
            // 두번째로 큰 값을 더해준다. 
            sum += ((max_num * K) + second_max_num);
            M -= (K + 1);
        }

        System.out.println(sum);
    }
}