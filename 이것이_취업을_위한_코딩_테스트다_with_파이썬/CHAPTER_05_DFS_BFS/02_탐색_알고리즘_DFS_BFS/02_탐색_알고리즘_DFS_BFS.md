# 02 탐색 알고리즘 DFS BFS

## 그래프의 기본 구조 
그래프는 **노드**와 **간선**으로 표현되며 이때 노드를 **정점** 이라고도 한다.<br>
그래프 탐색이란 하나의 노드를 시작으로 다수의 노드를 방문하는 것을 말한다. 

![/이것이_취업을_위한_코딩_테스트다_with_파이썬/img/그래프_노드_간선.png](/이것이_취업을_위한_코딩_테스트다_with_파이썬/img/그래프_노드_간선.png)

프로그래밍에서 그래프는 크게 2가지 방식으로 표현할 수 있다. 
1. 인접 행렬(Adjacency Matrix) : 2차원 배열로 그래프의 연결 관계를 표현하는 방식 
2. 인접 리스트(Adjacency List) : 리스트로 그래프의 연결 관계를 표현하는 방식 

### 인접 행렬 방식
> 2차원 배열에 각 노드가 연결된 형태를 기록하는 방식 

![/이것이_취업을_위한_코딩_테스트다_with_파이썬/img/그래프_인접_행렬.png](/이것이_취업을_위한_코딩_테스트다_with_파이썬/img/그래프_인접_행렬.png)

||0|1|2|
|---|---|---|---|
|0|0|7|5|
|1|7|0|무한|
|2|5|무한|0|

1. 위와 같이 연결된 그래프를 인접 행렬로 표현할 때 2차원 리스트로 구현할 수 있음 
2. 연결되지 않은 노드끼리는 무한의 비용이라고 작성한다. 

0 노드에서 0 노드는 같은 노드이기 떄문에 0<br>
0 노드에서 1 노드는 7 간선을 통해 갈 수 있기 때문에 7 <br>
0 노드에서 2 노드는 5 간선을 통해 갈 수 있기 떄문에 5

1 노드에서 0 노드는 7 간선을 통해 갈 수 있기 때문에 7<br>
1 노드에서 1 노드는 같은 노드이기 때문에 0<br>
1 노드에서 2 노드는 갈 수 없기 때문에 무한 

2 노드에서 0 노드는 5 간선을 통해 갈 수 있기 때문에 5<br>
2 노드에서 1 노드는 갈 수 없기 떄문에 무한<br>
2 노드에서 2 노드는 같은 노드이기 때문에 0 

```java
import java.util.*;

public class Main {
    public static final int INF = 999999999;
    
    // 2차원 리스트를 이용해 인접 행렬 표현
    public static int[][] graph = {
        {0, 7, 5},
        {7, 0, INF},
        {5, INF, 0}
    };

    public static void main(String[] args) {
        // 그래프 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

```
[[0,7,5], [7,0,999999999], [5,999999999,0]]
```

### 인접 리스트 방식
> 모든 노드에 연결된 노드에 대한 정보를 차례대로 연결하여 저장 

![/이것이_취업을_위한_코딩_테스트다_with_파이썬/img/그래프_인접_리스트.png](/이것이_취업을_위한_코딩_테스트다_with_파이썬/img/그래프_인접_리스트.png)

인접 리스트는 '연결 리스트'라는 자료구조를 이용해 구현 한다. 

```java
import java.util.*;

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.print("(" + this.index + "," + this.distance + ") ");
    }
}

public class Main {

    // 행(Row)이 3개인 인접 리스트 표현
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 노드 0에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        // 노드 1에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(1).add(new Node(0, 7));

        // 노드 2에 연결된 노드 정보 저장 (노드, 거리)
        graph.get(2).add(new Node(0, 5));

        // 그래프 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }
    }
}
```

```
[[(1,7),(2,5)],[(0,7)], [(0,5)]]
```

### 인접 행렬과 인접 리스트의 차이 

**메모리의 측면**
인접 행렬 방식 > 모든 관계를 저장하므로 노드 개수가 많을수록 메모리가 불필요하게 낭비<br>
인접 리스트 방식 > 연결된 정보만을 저장하기 때문에 메모리를 효율적으로 사용 

**속도의 측면**
인접 리스트 방식에서는 연결된 데이터를 하나씩 확인해야 하기 때문에 정보를 얻는 속도는 느림 

## DFS 
> 깊이 우선 탐색이라고도 부르며, 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘 

### 동작 과정 
1. 탐색 시작 노드를 스택에 삽입하고 방문 처리 
2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리를 한다. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다. 
3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복 

일반적으로 인접한 노드 중에서 방문하지 않은 노드가 여러 개 있으면 번호가 낮은 순서부터 처리 

### 특징 
1. 스택 자료구조에 기초한다는 점에서 구현이 간단 
2. 실제로는 스택을 쓰지 않아도 되며 탐색을 수행함에 있어서 데이터의 개수가 N개인 경우 O(N)의 시간이 소요 
3. 스택을 이용하는 알고리즘이기 때문에 실제 구현은 재귀 함수를 이용했을 때 매우 간결하게 구현 가능 

### 소스 
```java
import java.util.*;

public class Main {
    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // DFS 함수 정의
    public static void dfs(int x) {
        // 현재 노드를 방문 처리
        visited[x] = true;
        System.out.print(x + " ");
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        // 노드 2에 연결된 노드 정보 저장 
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        // 노드 3에 연결된 노드 정보 저장 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        // 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // 노드 6에 연결된 노드 정보 저장 
        graph.get(6).add(7);
        
        // 노드 7에 연결된 노드 정보 저장 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // 노드 8에 연결된 노드 정보 저장 
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
    }
}
```

## BFS
> 가까운 노드부터 탐색하는 알고리즘 

### 동작 방식 
1. 탐색 시작 노드를 큐에 삽입하고 방문 처리 
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리 
3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복 

### 특징 
1. 큐 자료구조에 기초한다는 점에서 구현이 간단 
2. 탐색을 수행함에 있어 O(N)의 시간 소요 
3. 실제 수행 시간은 DFS 보다 좋음 

### 코드
```java
import java.util.*;

public class Main {
    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // BFS 함수 정의
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        // 현재 노드를 방문 처리
        visited[start] = true;
        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int x = q.poll();
            System.out.print(x + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for(int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        // 노드 2에 연결된 노드 정보 저장 
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        // 노드 3에 연결된 노드 정보 저장 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        // 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // 노드 6에 연결된 노드 정보 저장 
        graph.get(6).add(7);
        
        // 노드 7에 연결된 노드 정보 저장 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // 노드 8에 연결된 노드 정보 저장 
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }
}
```

## DFS vs BFS 
||DFS|BFS|
|---|---|---|
|동작 원리|스택|큐|
|구현 방법|재귀 함수 이용|큐 자료구조 이용|