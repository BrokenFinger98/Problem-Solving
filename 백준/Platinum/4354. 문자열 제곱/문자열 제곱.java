import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s;
    static int[] fail;
    static char[] text;
    static char[] pattern;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            answer = 0;
            s = br.readLine();
            if(s.equals(".")) break;
            pattern = s.toCharArray();
            s += s;
            text = s.toCharArray();

            fail = new int[pattern.length];
            fail[0] = 0;
            int j = 0;
            for (int i = 1; i < pattern.length; i++) {
                while (j > 0 && pattern[j] != pattern[i]){
                    j = fail[j-1];
                }
                if(pattern[j] == pattern[i]) fail[i] = ++j;
            }

            j = 0;
            for (int i = 0; i < text.length; i++) {
                while (j > 0 && text[i] != pattern[j])
                    j = fail[j-1];
                if(text[i] == pattern[j]){
                    if(j == pattern.length-1){
                        ++answer;
                        j = fail[j];
                    }else{
                        ++j;
                    }
                }
            }

            sb.append(answer-1).append("\n");
        }
        System.out.print(sb);
    }
}

