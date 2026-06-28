import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
            queue.offer(works[i]);
        }
        
        while (n > 0) {
            int tmp = queue.poll();
            if (tmp == 0) break;
            tmp--;
            n--;
            queue.offer(tmp);
        }
        
        while (!queue.isEmpty()) {
            int t = queue.poll();
            answer += t * t;
        }
        
        return answer;
    }
}