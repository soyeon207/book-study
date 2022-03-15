public class 삽입_정렬 {
    public static void main(String[] args) {
        
        int arr[] = {7,5,9,0,3,1,6,2,4,8};
        int temp;
        
        for(int i=1;i<arr.length;i++) {
            for(int j=0;j<i;j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    continue;
                }
            }
        }
        
        for(int a:arr) {
            System.out.print(a+ " ");
        }
    }
}
