import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[500][500];
        dp[0][0] = triangle[0][0];
        int answer = 0;
        for(int i = 1; i < triangle.length; ++i){
            for(int j = 0; j < triangle[i].length; ++j){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }else if(j == triangle[i].length - 1){
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
                
                if(i == triangle.length - 1){
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
        
        return answer;
    }
}