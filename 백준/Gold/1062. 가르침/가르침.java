import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static int N, K;
    static String s, temp;
    static Set<Character>[] words;
    static Set<Character> set = new HashSet<>();
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5){
            System.out.println(0);
            System.exit(0);
        }
        words = new Set[N];

        for(int i = 0; i < N; ++i){
            s = br.readLine();
            temp = s.substring(4, s.length() - 4);
            words[i] = new HashSet<>();
            for(char c : temp.toCharArray()){
                words[i].add(c);
            }
        }

        set.add('a');
        set.add('n');
        set.add('t');
        set.add('i');
        set.add('c');
        combi(0, 0);

        System.out.println(result);
        br.close();
    }

    static void combi(int depth, int start){
        if(depth == K-5){
            int ans = 0;
            for(Set<Character> word : words){
                if(set.containsAll(word)) ++ans;
            }
            result = Math.max(result, ans);
        }

        for(int i = start; i < 26; ++i){
            if('a' != 'a' + i && 'n' != 'a' + i && 't' != 'a' + i && 'i' != 'a' + i && 'c' != 'a' + i){
                set.add((char) ('a' + i));
                combi(depth + 1 ,i + 1);
                set.remove((char) ('a' + i));
            }
        }
    }
}
