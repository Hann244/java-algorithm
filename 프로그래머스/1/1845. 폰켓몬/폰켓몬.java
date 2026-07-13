import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> set = Arrays.stream(nums)
                                .boxed()
                                .collect(Collectors.toSet());
        
        return set.size() > (nums.length / 2) ? nums.length / 2 : set.size();
    }
}