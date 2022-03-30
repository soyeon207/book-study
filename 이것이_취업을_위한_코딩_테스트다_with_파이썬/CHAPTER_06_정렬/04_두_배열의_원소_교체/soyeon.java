import java.util.Scanner;

class soyeon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int first_arr[] = new int[N];
        int second_arr[] = new int[N];
        int first_temp, second_temp, sum_count = 0;
        
        for(int i=0; i<N;i++) first_arr[i] = sc.nextInt();
        for(int j=0; j<N; j++) second_arr[j] = sc.nextInt();
        
        for(int k=1; k<N; k++) {
            for(int l=0; l<k; l++) {
                if (first_arr[k] < first_arr[l]) {
                    first_temp = first_arr[k];
                    first_arr[k] = first_arr[l];
                    first_arr[l] = first_temp;
                }
                
                if(second_arr[k] > second_arr[l]) {
                    second_temp = second_arr[k];
                    second_arr[k] = second_arr[l];
                    second_arr[l] = second_temp;
                }
            }
        }
        
        for(int i=0; i<K; i++) sum_count += second_arr[i];
        for(int i=K; i<N; i++) sum_count += first_arr[i];

        System.out.println(sum_count);
    }
}