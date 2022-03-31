import java.util.Scanner;

public class 이진탐색_재귀 {

    public static int binary_search(int target, int[] arr, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (target == arr[mid]) {
            return mid + 1;
        } else if (target < arr[mid]) {
            return binary_search(target, arr, start, mid - 1);
        } else {
            return binary_search(target, arr, mid + 1, end);
        }   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int target = sc.nextInt();

        int arr[] = new int[size];
        for(int i=0;i<size;i++) {
            arr[i] = sc.nextInt();
        }
        
        int count = binary_search(target, arr, 0, arr.length - 1);
        System.out.println(count == -1 ? "원소가 존재하지 않습니다.": count);

    }
    
}
