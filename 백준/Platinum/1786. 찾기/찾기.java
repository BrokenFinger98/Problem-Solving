import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s1 = br.readLine();
        char[] text = s.toCharArray();
        char[] pattern = s1.toCharArray();
        int[] fail = makeTable(pattern);
        System.out.println(kmp(fail, text, pattern));
    }

    private static String kmp(int[] fail, char[] text, char[] pattern) {
        StringBuilder sb = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < text.length; i++) {
            while (j > 0 && text[i] != pattern[j])
                j = fail[j-1];
            if(text[i] == pattern[j]){
                if(j == pattern.length-1){
                    result.add(i-j+1);
                    j = fail[j];
                }else{
                    ++j;
                }
            }
        }
        sb.append(result.size()).append("\n");
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    private static int[] makeTable(char[] pattern) {
        int[] fail = new int[pattern.length];
        int j = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[j] != pattern[i])
                j = fail[j-1];
            if(pattern[j] == pattern[i]) fail[i] = ++j;
        }
        return fail;
    }
}

