import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 시간 : 464ms, 메모리 : 165,580KB
 */
public class Main {
    static int N, answer = 0;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static ArrayList<Integer> lis = new ArrayList<>();
    static int[] num;
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine()); // 수열의 크기 입력
        num = new int[N]; // 원본 수열
        path = new int[N]; // LIS의 경로 추적 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken()); // 수열 A 입력
        }

        // LIS 계산
        for (int i = 0; i < N; i++) {
            int pos = Collections.binarySearch(lis, num[i]); // LIS에서 이진 탐색
            if (pos < 0) {
                pos = -(pos + 1); // 적절한 위치를 찾는다.
            }

            if (pos == lis.size()) {
                lis.add(num[i]); // 새로운 값을 추가
            } else {
                lis.set(pos, num[i]); // 기존 값을 갱신
            }

            path[i] = pos; // 현재 수가 LIS에서 어떤 위치에 있는지 기록
        }

        answer = lis.size(); // LIS의 길이
        sb.append(answer).append("\n");

        // LIS를 역추적하여 정답 구하기
        int len = answer - 1; // LIS의 길이를 바탕으로 역추적 시작
        for (int i = N - 1; i >= 0; i--) {
            if (path[i] == len) {
                stack.push(num[i]);
                len--;
            }
        }

        // 스택에 저장된 LIS 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
