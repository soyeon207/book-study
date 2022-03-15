class 선택_정렬 {
    public static void main(String[] args) {
        
        int arr[] = {7,5,9,0,3,1,6,2,4,8};
        int min_num,temp;
        
        for(int i=0;i<arr.length;i++) {
            min_num = i;
            for(int j=i+1;j<arr.length;j++) {
                if (arr[min_num] > arr[j]) {
                    min_num = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min_num];
            arr[min_num] = temp;
        }
        
        for(int a:arr) {
            System.out.print(a + " ");
        }
        
    }
}