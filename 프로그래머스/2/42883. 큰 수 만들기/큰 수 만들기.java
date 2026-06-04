class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            
            while (!sb.isEmpty() 
                   && k > 0 
                   && sb.charAt(sb.length() - 1) < current) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            
            sb.append(current);
        }
        
        if (k != 0) sb.setLength(number.length() - k);
        
        return sb.toString();
    }
}