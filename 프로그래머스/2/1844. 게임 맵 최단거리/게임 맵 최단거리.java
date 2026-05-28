import java.util.*;
import java.awt.Point;

class Solution {
    
    static int n, m;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    static boolean[][] visited;
    static int[][] map;
    
    public int solution(int[][] maps) {
        
        map = maps;
        
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
                
        int answer = bfs(0, 0);
        if (answer == 1) answer = -1;
        return answer;
    }
    
    static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Point currentPoint = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = currentPoint.x + dx[i];
                int ny = currentPoint.y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                
                q.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                map[nx][ny] = map[currentPoint.x][currentPoint.y] + 1;
            }
        }
        return map[n - 1][m - 1];
    }
}