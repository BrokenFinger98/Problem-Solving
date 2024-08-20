import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int number, level, oper;
    static String operation;
    static TreeMap<Integer, TreeSet<Integer>> maps = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            level = Integer.parseInt(st.nextToken());
            TreeSet<Integer> set = maps.get(level);
            if (set != null) {
                set.add(number);
                maps.put(level, set);
            } else {
                TreeSet<Integer> newSet = new TreeSet<>();
                newSet.add(number);
                maps.put(level, newSet);
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            operation = st.nextToken();
            if (operation.equals("add")) {
                number = Integer.parseInt(st.nextToken());
                level = Integer.parseInt(st.nextToken());
                TreeSet<Integer> set = maps.get(level);
                if (set != null) {
                    set.add(number);
                    maps.put(level, set);
                } else {
                    TreeSet<Integer> newSet = new TreeSet<>();
                    newSet.add(number);
                    maps.put(level, newSet);
                }
            } else if (operation.equals("recommend")) {
                oper = Integer.parseInt(st.nextToken());
                if (oper == 1) {
                    System.out.println(maps.get(maps.lastKey()).last());
                } else {
                    System.out.println(maps.get(maps.firstKey()).first());
                }
            } else {
                number = Integer.parseInt(st.nextToken());
                Integer key = null;
                for (Map.Entry<Integer, TreeSet<Integer>> entry : maps.entrySet()) {
                    TreeSet<Integer> set = entry.getValue();
                    if(set.contains(number)) {
                        if (set.size() == 1) {
                            key = entry.getKey();
                        }else{
                            set.remove(number);
                        }
                        break;
                    }
                }
                if(key != null) maps.remove(key);
            }
        }
        br.close();
    }
}
