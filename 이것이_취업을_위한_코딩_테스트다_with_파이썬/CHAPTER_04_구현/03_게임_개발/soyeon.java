import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 맵의 세로 크기
    int M = sc.nextInt(); // 맵의 가로 크기

    int A = sc.nextInt(); // 게임 캐릭터 좌표 X
    int B = sc.nextInt(); // 게임 캐릭터 좌표 Y
    int d = sc.nextInt(); // 게임 캐릭터가 바라보는 방향 d 

    int map[][] = new int[N][M]; // 맵 배열 

    // d = 0 , 북 / d = 1 , 동 / d = 2 , 남 / d = 3 , 서
    int move[][] = {{-1,0}, {0,1}, {1, 0}, {0, -1}}; // 이동해야할 거리 
    int next_move[] = {3,0,1,2};                     // 다음으로 바라봐야 할 위치 
    int back_move[] = {2,3,0,1};                     // 뒤로 가야하는 위치 

    // 육지인지 바다인지 여부 입력받음 
    for(int i=0;i<map.length;i++) {
      for(int j=0;j<map[0].length;j++) {
        map[i][j] = sc.nextInt();
      }
    }

    int temp_X, temp_Y;       // 움직일 X,Y 후보 
    boolean is_count = false; // 움직였는지 여부를 저장하는 변수 
    int count = 1;            // 움직인 횟수 count

    while(true) {
      for(int i=0;i<4;i++) {
        // 아직 움직이지 못한 경우 
        if (is_count == false) { 
          temp_X = move[next_move[((d + i) % 4)]][0];
          temp_Y = move[next_move[((d + i) % 4)]][1];
          // 움직이려는 위치가 육지인 경우 
          if (temp_X + A < N && temp_X + A >= 0 && temp_Y + B < M && temp_Y + B >= 0 && map[temp_X + A][temp_Y + B] == 0) {
              map[A][B] = 2;                // 있었던 위치를 2로 
              d = next_move[((d + i) % 4)]; // 방향을 움직인 방향으로 변경 
              A += temp_X;                  // X 이동 
              B += temp_Y;                  // Y 이동 
              count ++;                     // 움직인 횟수를 1 더해줌 
              map[A][B] = 2;                // 움직이는 위치를 2로 
              is_count = true;              
          }
        }
      }

      if (is_count) { // 이동한 경우 
        is_count = false;
      } else { // 이동하지 못한 경우 
        // 바라보는 방향을 유지한 채로 뒤로 이동 
        temp_X = move[back_move[d]][0];
        temp_Y = move[back_move[d]][1];
        
        if (temp_X + A < N && temp_X + A >= 0 && temp_Y + B < M && temp_Y + B >= 0 && map[temp_X + A][temp_Y + B] != 1) {
            // 만약 뒤가 육지 인경우 뒤로 이동해주고 
            A += temp_X;
            B += temp_Y;
        } else {
            // 육지가 아닌 경우 움직임을 멈춤 
            break;
        }
      }
    }
    
    System.out.println(count);
  }
}
