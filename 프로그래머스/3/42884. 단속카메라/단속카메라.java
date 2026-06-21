import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        // 나가는 기준으로 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        // 첫 번째 차량의 나가는 지점 카메라로 설정
        int camera = routes[0][1];
        int answer = 1;
        
        // 나머지 차량의 구간이 포함되는지 확인
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] <= camera && camera <= routes[i][1]) {
            } else {
                // 포함되지 않는다면 새 카메라로 변경
                camera = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}