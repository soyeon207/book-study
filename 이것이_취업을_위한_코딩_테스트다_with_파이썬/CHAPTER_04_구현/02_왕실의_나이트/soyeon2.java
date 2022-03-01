import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String coordinate = sc.next();
    
        int coordinate_x = (coordinate.charAt(0) - 'a' + 1);
        int coordinate_y = coordinate.charAt(1) - '0';
        
        // 움직일 수 있는 경우의 수를 이중 배열로 저장 
        int move_arr[][] = { {-1,-2}, {1,-2}, {2,-1}, {2,1}, {-1, 2}, {1,2},{-2,-1}, {-2,1}};
        
        int count = 0;
        for(int i=0;i<move_arr.length;i++) {
            // 이동했을 때 x 나 y 가 8을 넘거나 0이 되지 않았는지 확인 
            if(coordinate_x + move_arr[i][0] <= 8 && coordinate_x + move_arr[i][0] > 0 
                && coordinate_y + move_arr[i][1] <= 8 && coordinate_y + move_arr[i][1] > 0) {
                count++;
            }   
        }
        
        System.out.println(count);
    
    }
}