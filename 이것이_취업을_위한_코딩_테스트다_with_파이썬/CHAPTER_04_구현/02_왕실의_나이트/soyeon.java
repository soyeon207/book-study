import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String coordinate = sc.next();
    
        // 나이트가 갈 수 있는 방향을 x와 y , x2 와 y2 배열로 모두 지정
        // x,y 는 수직 혹은 수평으로 두칸 이동할 때 
        // x2, y2 는 수직 혹은 수평으로 한칸 이동할 때를 저장해둔 배열임  
        int x[] = {-2, 0, 2, 0}; 
        int y[] = {0, 2, 0, -2};
        int x2[] = {0, 1, 0, 1};
        int y2[] = {1,0,1,0};
    
        int coordinate_x = (coordinate.charAt(0) - 'a' + 1);
        int coordinate_y = coordinate.charAt(1) - '0';
        
        int count = 0;
        // 동서남북 4번 갈 수 있기 때문에 반복문을 4번 돔 
        for(int i=0;i<4;i++) {
            // 첫번째로 두칸 이동했을 때 x 나 y 가 8을 넘거나 0이 되지 않았는지 확인 
            if (coordinate_x + x[i] <= 8 && coordinate_x + x[i] > 0 && coordinate_y + y[i] <= 8 && coordinate_y + y[i] > 0) {
                // 두번째로 +, - 두번 이동할 수 있기 때문에 두번 검사 
                if (coordinate_x + x2[i] <= 8 && coordinate_x + x2[i] > 0 && coordinate_y + y2[i] <= 8 && coordinate_y + y2[i] > 0) {
                    count++;
                }
                
                if (coordinate_x - x2[i] <= 8 && coordinate_x - x2[i] > 0 && coordinate_y - y2[i] <= 8 && coordinate_y - y2[i] > 0) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}