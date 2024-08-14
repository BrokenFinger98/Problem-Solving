import java.io.*;
import java.lang.*;
import java.util.*;

class Pair{
    int y;
    int x;
    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class Main {
    static int N, M;
    static int ans;
    static List<Pair> chicken = new ArrayList<>();
    static List<Pair> house = new ArrayList<>();
    static List<Pair> selectedChicken = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 2*N*2*N;
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j){
                int e = Integer.parseInt(st.nextToken());
                if(e == 1){
                    house.add(new Pair(i, j));
                }else if(e == 2){
                    chicken.add(new Pair(i, j));
                }
            }
        }

        combi(0, 0);

        System.out.println(ans);
        br.close();
    }
    static void combi(int depth, int start){
        if(depth == M){
            int sum = 0;
            for(int i = 0; i < house.size(); ++i){
                int minValue = 2*N;
                for(int j = 0; j < selectedChicken.size(); ++j){
                    int y = Math.abs(house.get(i).y - selectedChicken.get(j).y);
                    int x = Math.abs(house.get(i).x - selectedChicken.get(j).x);
                    minValue = Math.min(minValue, y+x);
                }
                sum += minValue;
            }
            ans = Math.min(ans, sum);
        }

        for(int i = start; i < chicken.size(); ++i){
            Pair selected = chicken.get(i);
            selectedChicken.add(selected);
            combi(depth + 1, i + 1);
            selectedChicken.remove(selected);
        }
    }
}
