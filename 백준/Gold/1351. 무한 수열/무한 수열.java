import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static String N, P, Q;
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        P = st.nextToken();
        Q = st.nextToken();
        System.out.println(go(N));
    }
    static String go(String s){
        if(s.equals("0")){
            map.put(s, "1");
            return "1";
        }
        if(map.get(s) == null){
            long a = Long.parseLong(go(String.valueOf(Long.parseLong(s)/Integer.parseInt(P))));
            long b = Long.parseLong(go(String.valueOf(Long.parseLong(s)/Integer.parseInt(Q))));
            map.put(s, String.valueOf(a+b));
        }
        return map.get(s);
    }
}

