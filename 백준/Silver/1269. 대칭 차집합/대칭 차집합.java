import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static int A, B;
    static Set<Integer> setA = new HashSet<>();
    static Set<Integer> setB = new HashSet<>();
    static Set<Integer> ADifferenceB = new HashSet<>();
    static Set<Integer> BDifferenceA = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; ++i){
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; ++i){
            setB.add(Integer.parseInt(st.nextToken()));
        }

        ADifferenceB.addAll(setA);
        ADifferenceB.removeAll(setB);
        BDifferenceA.addAll(setB);
        BDifferenceA.removeAll(setA);
        ADifferenceB.addAll(BDifferenceA);

        System.out.println(ADifferenceB.size());
        br.close();
    }
}