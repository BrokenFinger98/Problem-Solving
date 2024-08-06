import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static int N, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if(abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });
        for(int i = 0; i < N; ++i){
            e = Integer.parseInt(br.readLine());
            if(e == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }else{
                pq.offer(e);
            }
        }
    }
}