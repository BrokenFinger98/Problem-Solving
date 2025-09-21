import java.util.*;

class Solution {
    public int solution(String numbers) {
        int n = numbers.length();
        boolean[] isSelected = new boolean[n];
        Set<Integer> primes = new HashSet<>();
        
        for(int i = 1; i <= n; ++i){
            permutation(numbers, new StringBuilder(), isSelected, i, 0, primes);
        }
        
        int answer = 0;
        for(Integer num : primes){
            if(isPrime(num)) ++answer;
        }
        return answer;
    }
    
    public void permutation(String numbers, StringBuilder sb, boolean[] isSelected, int n , int depth, Set<Integer> primes){
        if(depth == n){
            primes.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        for(int i = 0; i < numbers.length(); ++i){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            sb.append(numbers.charAt(i));
            permutation(numbers, sb, isSelected, n, depth+1, primes);
            isSelected[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i * i <= num; ++i){
            if(num % i == 0) return false;
        }
        return true;
    }
}