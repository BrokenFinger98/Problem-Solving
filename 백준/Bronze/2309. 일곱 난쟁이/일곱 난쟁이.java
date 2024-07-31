import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; ++i) {
            list.add(Integer.parseInt(br.readLine()));
            sum += list.get(i);
        }
        Collections.sort(list);

        sum -= 100;
        int a = 0 , b = 0;
        for(int i = 0; i < list.size(); ++i){
            for(int j = i+1; j < list.size(); ++j){
                if(sum == list.get(i) + list.get(j)){
                    a = i; b = j;
                    break;
                }
            }
        }

        for(int i = 0; i < list.size(); ++i){
            if(i == a || i == b) continue;
            System.out.println(list.get(i));
        }
    }
}