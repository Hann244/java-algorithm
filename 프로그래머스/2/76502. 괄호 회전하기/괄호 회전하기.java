import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Deque<Character> deque = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            deque.addLast(s.charAt(i));
        }
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            
            for (char current : deque) {
                if ((current == '(') 
                     || (current == '{')
                     || (current == '[')
                   ) {
                    stack.push(current);
                } 
                
                if (stack.isEmpty() 
                    && (current == ')' || current == '}' || current == ']')) {
                    flag = false;
                }
                
                if (!stack.isEmpty() 
                       && ((stack.peek() == '(' && current == ')') 
                       || (stack.peek() == '{' && current == '}') 
                       || (stack.peek() == '[' && current == ']'))
                      ) {
                            stack.pop();
                       } 
                else if (!stack.isEmpty() 
                       && ((stack.peek() != '(' && current == ')') 
                       || (stack.peek() != '{' && current == '}') 
                       || (stack.peek() != '[' && current == ']'))) {
                            flag = false;
                            break;
                       }
            }

            if (flag && stack.isEmpty()) answer++;
            
            deque.addLast(deque.removeFirst());
        }
        
        return answer;
    }
}