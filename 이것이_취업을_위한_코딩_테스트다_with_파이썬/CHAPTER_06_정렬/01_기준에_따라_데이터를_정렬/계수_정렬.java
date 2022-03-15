public class 계수_정렬 {

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int max_num = 9;
        int count[] = new int[max_num + 1];
        
        for(int i=0;i<arr.length;i++) {
            count[arr[i]]++;
        }
        
        for(int i=0;i<count.length;i++) {
            for(int j=0;j<count[i];j++) {
                System.out.print(i+ " ");
            }
        }
    }
    
}
