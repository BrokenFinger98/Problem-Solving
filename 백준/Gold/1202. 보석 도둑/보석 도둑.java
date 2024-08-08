import java.io.*;
import java.lang.*;
import java.util.*;

class Jewel{
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}
public class Main {
    static int N, K;
    static long sum;
    static List<Jewel> jewels = new ArrayList<>();
    static List<Integer> bag = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, price));
        }
        for (int i = 0; i < K; ++i) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        jewels.sort((o1, o2) -> {
            if(o1.weight == o2.weight) return o2.price - o1.price;
            return o1.weight - o2.weight;
        });
        bag.sort(null);

        int j = 0;
        for (int i = 0; i < K; ++i) {
            while (j < N && jewels.get(j).weight <= bag.get(i)) {
                pq.offer(jewels.get(j++).price);
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        System.out.println(sum);
        br.close();
    }
}