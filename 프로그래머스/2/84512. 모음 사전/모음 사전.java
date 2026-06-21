class Solution {
    static int answer = 0;
    static int count = 0;
    static String[] dict = {"A", "E", "I", "O", "U"};
    static String target;
    
    public int solution(String word) {
        target = word;
        dfs("");
        
        return answer;
    }
    
    private static void dfs(String t) {
        if (!t.equals("")) count++;
        if (t.equals(target)) answer = count;
        if (t.length() == 5) return;
        
        for (int i = 0; i < 5; i++) {
            dfs(t + dict[i]);
        }
    }
}