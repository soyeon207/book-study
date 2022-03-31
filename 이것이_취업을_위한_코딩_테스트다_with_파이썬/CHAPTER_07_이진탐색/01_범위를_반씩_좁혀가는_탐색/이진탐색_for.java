import java.util.*;

public class 이진탐색_for {

    public void binary_search(int target, int[] arr) {
        
        int start = 0;
        int end = arr.size();
        int mid = (start + end) / 2;
        int count = 0;
        
        while(start != mid && end != mid) {
            if (target == arr[mid]) {
                return count;
            } else if (target < arr[mid]) {
                
            } else if (target > arr[mid]) {
                
            }
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
        
        binary_search(target, arr);
        
    }

}