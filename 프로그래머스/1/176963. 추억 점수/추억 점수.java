import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        // 1. 이름표가 붙은 사물함(HashMap) 만들기
        // Key는 사람 이름(String), Value는 추억 점수(Integer)
        Map<String, Integer> scoreMap = new HashMap<>();
        
        // 2. 사물함에 데이터 채워넣기
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }
        
        // 3. 점수 계산하기
        for (int i = 0; i < photo.length; i++) {
            int tmp = 0;
            for (String person : photo[i]) {
                // 사물함에서 person의 이름을 찾아 점수를 꺼냄 (없으면 기본값 0)
                // getOrDefault: 찾는 Key가 Map에 있으면 그 Value를 주고, 없으면 뒤에 적은 기본값(0)을 줍니다.
                tmp += scoreMap.getOrDefault(person, 0);
            }
            answer[i] = tmp;
        }
        
        return answer;
    }
}