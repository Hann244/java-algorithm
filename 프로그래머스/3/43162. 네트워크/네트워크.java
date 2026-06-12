class Solution {
    
    static boolean[] visited;
    static int[][] graph;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        graph = computers;
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int x) {
        visited[x] = true;
        
        for (int i = 0; i < graph.length; i++) {
            if (x != i
               && graph[x][i] == 1
               && !visited[i]) {
                dfs(i);
            }

        }
    }
}