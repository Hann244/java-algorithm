class Solution {
    public int solution(int[][] triangle) {
        
        for (int i = triangle.length - 2; i > -1; i--) {
            for (int j = 0; j <= i; j++) {
                // 아래에 있는 왼쪽, 오른쪽 값을 비교
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        return triangle[0][0];
    }
}