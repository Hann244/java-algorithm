import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // Stack<Character> 선언
        Stack<Character> stack = new Stack<>();
        // StringBuilder 선언
        StringBuilder sb = new StringBuilder();
        
        // for 반복 (숫자 읽기)
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            
            // 값 비교
            while (!stack.isEmpty() 
                   && k > 0
                  && stack.peek() < current) {
                stack.pop();
                k--;
            }
            
            stack.push(current);
        }
        
        // k가 남은 경우 (ex. "4321", k = 2, -> 4321로 stack에 담기고 k는 그대로 남음)
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        for (char c : stack) {
            sb.append(c);
        }
        
        String answer = sb.toString();
        return answer;
    }
}