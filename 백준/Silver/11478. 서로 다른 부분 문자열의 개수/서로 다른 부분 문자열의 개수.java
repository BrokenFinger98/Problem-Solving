import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < s.length(); ++i){
            for(int j = 1; j < s.length()-i+1; ++j){
                set.add(s.substring(i, i+j));
            }
        }
        System.out.println(set.size());
        br.close();
    }
}