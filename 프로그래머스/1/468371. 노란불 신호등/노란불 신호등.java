class Solution {
    public int solution(int[][] signals) {
        
        int answer = 0;
        
        int maxTime = signals[0][0] + signals[0][1] + signals[0][2];
        
        for (int i = 1; i < signals.length; i++) {
            int currentTime = signals[i][0] + signals[i][1] + signals[i][2];
            
            maxTime = lcm(maxTime, currentTime);
        }
        
        while (answer < maxTime) {
            boolean isAllYellow = true;
            
            for (int[] currentSignals : signals) {
                
                int green = currentSignals[0];
                int yellow = currentSignals[1];
                int red = currentSignals[2];
                
                if (answer % (green + yellow + red) < green || 
                    answer % (green + yellow + red) >= (green + yellow)) {
                    isAllYellow = false;
                    break;
                }
                
            }
            
            answer++;
            if (isAllYellow) return answer;
                
        }
        
        return -1;
    }
    
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    static int lcm(int a, int b) {
         return (a * b) / gcd(a, b);
    }
}