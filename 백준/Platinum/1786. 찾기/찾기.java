import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> result = new ArrayList<>();
    static int[] fail;
    static char[] text;
    static char[] pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String s1 = br.readLine();
        s = "#" + s;
        s1 = "#" + s1;
        text = s.toCharArray();
        pattern = s1.toCharArray();
        fail = new int[pattern.length];
        fail[0] = -1;
        for (int i = 1; i < pattern.length; i++) {
            int j = fail[i-1];
            while (j >= 0 && pattern[j+1] != pattern[i])
                j = fail[j];
            fail[i] = j + 1;
        }
        int j = 0;
        for (int i = 1; i < text.length; i++) {
            while (j >= 0 && text[i] != pattern[j+1])
                j = fail[j];
            j++;
            if(j == pattern.length-1){
                result.add(i-j+1);
                j = fail[j];
            }
        }
        sb.append(result.size()).append("\n");
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}

