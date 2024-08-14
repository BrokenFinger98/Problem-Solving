import javax.swing.plaf.DesktopIconUI;
import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    static int T, N;
    static String s = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        for(int t = 1; t <= 10; ++t){
            N = Integer.parseInt(br.readLine());
            s = br.readLine();
            sb = new StringBuilder();
            Deque<Character> stack = new ArrayDeque<>();
            
            for (int i = 0; i < N; ++i){
                if(!stack.isEmpty()){
                    char c = stack.peek();
                    char next = s.charAt(i);
                    if(c == '('){
                        if(next == ')') stack.pop();
                        else stack.push(next);
                    }else if(c == '['){
                        if(next == ']') stack.pop();
                        else stack.push(next);
                    }else if(c == '{'){
                        if(next == '}') stack.pop();
                        else stack.push(next);
                    }else if(c == '<'){
                        if(next == '>') stack.pop();
                        else stack.push(next);
                    }
                }else{
                    stack.push(s.charAt(i));
                }
            }

            sb.append('#').append(t).append(" ");
            if(stack.isEmpty()){
                sb.append(1);
            }else{
                sb.append(0);
            }
            System.out.println(sb.toString());
        }
        br.close();
    }
}
