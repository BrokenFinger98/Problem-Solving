import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static int N, value;
    static PriorityQueue<Integer> pqFirstHalf = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> pqSecondHalf = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            value = Integer.parseInt(st.nextToken());

            if(pqFirstHalf.isEmpty()){
                pqFirstHalf.offer(value);
                System.out.println(pqFirstHalf.peek());
                continue;
            }

            if(pqSecondHalf.isEmpty()){
                if (pqFirstHalf.peek() <= value) {
                    pqSecondHalf.offer(value);
                }else{
                    pqSecondHalf.offer(pqFirstHalf.poll());
                    pqFirstHalf.offer(value);
                }
                System.out.println(pqFirstHalf.peek());
                continue;
            }

            if(pqFirstHalf.peek() <= value){
                if(pqFirstHalf.size() > pqSecondHalf.size()){
                    pqSecondHalf.offer(value);
                }else{
                    if(pqSecondHalf.peek() >= value){
                        pqFirstHalf.offer(value);
                    }else{
                        pqFirstHalf.offer(pqSecondHalf.poll());
                        pqSecondHalf.offer(value);
                    }
                }
            } else if (pqFirstHalf.peek() > value) {
                pqFirstHalf.offer(value);
                if(pqFirstHalf.size() > pqSecondHalf.size()){
                    pqSecondHalf.offer(pqFirstHalf.poll());
                }
            }

            if (pqFirstHalf.size() >= pqSecondHalf.size()) {
                System.out.println(pqFirstHalf.peek());
            }else {
                System.out.println(pqSecondHalf.peek());
            }
        }
        br.close();
    }
}