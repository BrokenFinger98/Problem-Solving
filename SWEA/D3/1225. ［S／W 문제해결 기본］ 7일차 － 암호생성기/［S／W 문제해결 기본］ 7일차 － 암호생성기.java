import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        for(int t = 1; t <= 10; ++t){
            st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            list = new LinkedList<>();
            for(int i = 0; i < 8; ++i){
                list.add(Integer.parseInt(st.nextToken()));
            }

            encryption();

            sb.append("#").append(t).append(" ");
            for (Integer integer : list) {
                sb.append(integer).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    static void encryption(){
        int cnt = 1;
        while (true) {
            int integer = list.removeFirst() - cnt;
            if(integer <= 0){
                list.addLast(0);
                break;
            }else{
                list.addLast(integer);
            }
            cnt++;
            if(cnt == 6) cnt = 1;
        }
    }
}
