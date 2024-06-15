import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public int solution(int[] numbers) {
        List<Integer> candidates = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> numberList = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
        return candidates.stream()
                .filter(candidate -> !numberList.contains(candidate))
                .mapToInt(n -> n)
                .sum();
    }
}   