import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            switch (oper) {
                case "push":
                    int e = Integer.parseInt(st.nextToken());
                    stack.push(e);
                    break;

                case "pop":
                    if (stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.pop());
                    break;

                case "top":
                    if (stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.peek());
                    break;

                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                default:
                    break;
            }
        }
    }
}