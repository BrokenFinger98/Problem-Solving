import java.util.*;

class Main {
    static int N, K, r, cnt, ret;
    static ArrayList<Integer> a = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); K = sc.nextInt();

        for(int i = 2; i <= N; ++i){
            a.add(i);
        }

        while (cnt < K){
            if(a.isEmpty()) break;
            r = a.remove(0);
            ret = r;
            ++cnt;
            if(cnt >= K) break;
            for(int i = 0; i < a.size(); ++i){
                if(a.get(i) % r == 0){
                    ret = a.remove(i--);
                    ++cnt;
                    if(cnt >= K) break;
                }
            }
            if(cnt >= K) break;
        }

        System.out.println(ret);
        sc.close();
    }
}
