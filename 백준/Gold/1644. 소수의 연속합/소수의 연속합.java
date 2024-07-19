import java.io.*;
import java.util.*;

public class Main {
    static int N, ret;
    static ArrayList<Integer> a = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 2; i <= N; ++i) {
            int flag = 1;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) a.add(i);
        }
        for (int i = 0; i < a.size(); i++) {
            int sum = 0;
            for (int j = i; j < a.size() ; j++) {
                sum += a.get(j);
                if(sum == N) ++ret;
                if(sum > N) break;
            }
        }
        System.out.println(ret);
    }
}
