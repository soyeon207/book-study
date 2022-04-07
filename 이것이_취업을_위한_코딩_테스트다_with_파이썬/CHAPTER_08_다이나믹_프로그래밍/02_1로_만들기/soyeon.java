import java.util.Scanner;

class soyeon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int count = 0;
        
        while(X != 1) {
            if (X % 5 == 0) {
                X /= 5;
            } else if (X % 5 == 1) {
                X --;
            } else if (X % 3 == 0) {
                X /= 3;
            } else if (X % 3 == 1) {
                X --;
            } else if (X % 2 == 0) {
                X /= 2;
            } else {
                X --;
            }
            count ++;
        }
        System.out.println(count);
    }
}