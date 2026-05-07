class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int tmp = 0;
        
        for (int i = 0; i < photo.length; i++) {
            for (String nameCheck : photo[i]) {
                for (int j = 0; j < name.length; j++) {
                    if (name[j].equals(nameCheck)) tmp += yearning[j];
                }
            }
            answer[i] = tmp;
            tmp = 0;
        }
        
        return answer;
    }
}