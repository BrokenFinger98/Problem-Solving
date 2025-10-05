import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] minions = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; ++i){
			minions[i] = Integer.parseInt(br.readLine());
			sum += minions[i];
		}
		Arrays.sort(minions);
		int[] notMinionIndexes = findNotMinions(minions, sum);
		for(int i = 0; i < 9; ++i){
			if(notMinionIndexes[0] == i || notMinionIndexes[1] == i){
				continue;
			}
			sb.append(minions[i] + "\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static int[] findNotMinions(int[] minions, int sum) {
		int[] result = new int[2];
		for(int i = 0; i < 9; ++i){
			for(int j = i + 1; j < 9; ++j){
				if(sum - (minions[i] + minions[j]) == 100){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}
}