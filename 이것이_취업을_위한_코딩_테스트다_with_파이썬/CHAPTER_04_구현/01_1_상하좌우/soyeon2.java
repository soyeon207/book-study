import java.util.Scanner;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        
        int x = 1, y = 1;
        String plans[] = sc.nextLine().split(" ");
        
        HashMap<String, Integer> move_map = new HashMap<String, Integer>();
        move_map.put("L", 0);
        move_map.put("R", 1);
        move_map.put("U", 2);
        move_map.put("D", 3);
        
        int x_move[] = {0, 0, -1, 1};
        int y_move[] = {-1, 1, 0, 0};
        
        for(String plan:plans) {
            x+=x_move[move_map.get(plan)];
            y+=y_move[move_map.get(plan)];
            
            if (x < 1) x++;
            if (y < 1) y++;
        }
        
        System.out.println(x + " "+y);
        
    }
}