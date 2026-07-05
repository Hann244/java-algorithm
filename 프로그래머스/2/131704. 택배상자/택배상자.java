import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int orderIndex = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) {
            if (i == order[orderIndex]) {
                answer++;
                orderIndex++;
            } else {
                stack.push(i);
            }
            
            while (!stack.isEmpty()
                  && orderIndex < order.length
                  && stack.peek() == order[orderIndex]
                  ) {
                stack.pop();
                answer++;
                orderIndex++;
            }
        }
        
        return answer;
    }
}