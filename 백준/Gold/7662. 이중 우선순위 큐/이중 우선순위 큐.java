import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int T, Q, e;
    static String operator;
    static TreeMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            Q = Integer.parseInt(st.nextToken());
            map = new TreeMap<>();
            sb = new StringBuilder();
            for (int j = 0; j < Q; j++) {
                st = new StringTokenizer(br.readLine());
                operator = st.nextToken();
                e = Integer.parseInt(st.nextToken());
                if (operator.equals("I")) {
                    map.put(e, map.getOrDefault(e, 0) + 1);
                } else {
                    if(map.isEmpty())
                        continue;
                    if (e == 1) {
                        int value = map.get(map.lastKey());
                        if(value == 1){
                            map.remove(map.lastKey());
                        }else{
                            map.put(map.lastKey(), value - 1);
                        }
                    } else {
                        int value = map.get(map.firstKey());
                        if(value == 1){
                            map.remove(map.firstKey());
                        }else{
                            map.put(map.firstKey(), value - 1);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY");
            }else{
                if (map.size() == 1) {
                    e = map.firstKey();
                    sb.append(e).append(" ").append(e);
                } else {
                    int max = map.lastKey();
                    int min = map.firstKey();
                    sb.append(max).append(" ").append(min);
                }
            }
            System.out.println(sb.toString());
        }
        br.close();
    }
}
