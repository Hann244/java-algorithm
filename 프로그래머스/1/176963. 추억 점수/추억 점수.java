import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            int temp = 0;
            for (String p : photo[i]) {
                if (map.containsKey(p)) {
                    temp += map.get(p);
                }
            }
            answer[i] = temp;
        }
        
        return answer;
    }
}