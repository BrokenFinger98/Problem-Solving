import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[k+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] use = new boolean[101];
		int answer = 0;
		int put = 0;
		for (int i = 0; i < k; i++) {
			int temp = arr[i];
			if (!use[temp]) {//사용되지 않고 있는 전기용품이라면
				if (put < n) {//초기값 설정
					use[temp] = true;
					put++;
				} else {
					List<Integer> list = new ArrayList<>();
					for (int j = i; j < k; j++) {
						if (use[arr[j]] && !list.contains(arr[j])) {
							list.add(arr[j]);
						}
					}
					
					if (list.size() != n) {
						for (int j = 0; j < use.length; j++) {
							if (use[j] && !list.contains(j)) {//사용중인데 뒤에 나오지 않는다면
								use[j] = false;
								break;
							}
						}
					} else {
						int index = list.get(list.size() - 1);
						use[index] = false;
					}
					use[temp] = true;
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}
