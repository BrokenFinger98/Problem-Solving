import java.io.*;
import java.lang.*;
import java.util.*;

class Pair{
    int index;
    int value;
    public Pair(int index, int value){
        this.index = index;
        this.value = value;
    }
}
public class Main {
    static int N, L;
    static int[] A;
    static Deque<Pair> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
            if(deque.isEmpty()){
                deque.offer(new Pair(i, A[i]));
            }else{
                while (!deque.isEmpty() && i - deque.peekFirst().index == L) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && deque.peekLast().value >= A[i]){
                    deque.pollLast();
                }
                deque.offerLast(new Pair(i, A[i]));
            }
            sb.append(deque.peekFirst().value).append(" ");
        }

        System.out.println(sb.toString());
    }
}