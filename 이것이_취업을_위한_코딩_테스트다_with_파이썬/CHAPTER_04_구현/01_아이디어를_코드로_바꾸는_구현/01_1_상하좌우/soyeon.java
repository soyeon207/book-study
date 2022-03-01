import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        int x = 1, y = 1;
        String plans[] = sc.nextLine().split(" ");
        
        for(String plan:plans) {
            if (plan.equals("R") && y < N) y++;
           else if (plan.equals("L") && y > 1) y--;
           else if (plan.equals("U") && x > 1) x--;
           else if (plan.equals("D") && x < N) x++;
        }
        
        System.out.println(x + " "+y);
        
    }
}