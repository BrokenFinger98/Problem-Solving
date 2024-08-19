

import java.io.*;
import java.lang.*;
import java.util.*;

/*
 * 	
 * 	
 */
public class Solution {
	
	static int T, N, result;
	static int[][] S;
	static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;
 
        T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; ++t) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	S = new int[N][N];
        	isSelected = new boolean[N];
        	result = Integer.MAX_VALUE;
        	sb = new StringBuilder();
        	for(int i = 0 ; i < N; ++i) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0 ; j < N; ++j) {
        			S[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	 
        	combi(0, 0);
        	sb.append("#").append(t).append(" ").append(result);
        	System.out.println(sb.toString());
        }
        br.close();
    }
    static void combi(int depth, int start) {
    	if(depth == N/2) {
    		int[] numbers1 = new int[N/2];
    		int[] numbers2 = new int[N/2];
    		int a = 0;
    		int b = 0;
    		for(int i = 0; i < N; ++i) {
    			if(isSelected[i]){
    				numbers1[a++] = i;
    			}else {
    				numbers2[b++] = i;
    			}
    		}
    		int sum = 0;
    		for(int i = 0; i < N/2; ++i) {
    			for(int j = 0; j < N/2; ++j) {
    				if(i == j) continue;
    				sum += S[numbers1[i]][numbers1[j]];
    			}
    		}
    		for(int i = 0; i < N/2; ++i) {
    			for(int j = 0; j < N/2; ++j) {
    				if(i == j) continue;
    				sum -= S[numbers2[i]][numbers2[j]];
    			}
    		}
    		result = Math.min(result, Math.abs(sum));
    	}
    	
    	for(int i = start; i < N; ++i) {
    		isSelected[i] = true;
    		combi(depth + 1, i + 1);
    		isSelected[i] = false;
    	}
    }
}
