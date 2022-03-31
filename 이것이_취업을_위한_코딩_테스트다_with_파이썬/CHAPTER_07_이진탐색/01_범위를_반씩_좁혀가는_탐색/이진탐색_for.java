import java.util.*;

public class 이진탐색_for {

    public static int binary_search(int target, int[] arr) {
        int start = 0, end = arr.length, mid;
        
        while(start <= end) {
            mid = (start + end) / 2;
            if (target == arr[mid]) {
                return mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }   
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        int target = sc.nextInt();
        
        int arr[] = new int[size];
        for(int i=0;i<size;i++) {
            arr[i] = sc.nextInt();
        }
        
        int count = binary_search(target, arr);
        System.out.println(count == -1 ? "원소가 존재하지 않습니다.": count);
        
    }

}