import java.io.*;
import java.util.*;

public class Main {
    static int MAX_CARD_SIZE = 10000004;
    static int MAX_SIZE = 100004;
    static int N;
    static int[] player = new int[MAX_SIZE];
    static int[] score = new int[MAX_CARD_SIZE];
    static boolean[] card = new boolean[MAX_CARD_SIZE];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            player[i] = Integer.parseInt(st.nextToken());
            card[player[i]] = true;
        }
        for(int i = 0; i < MAX_CARD_SIZE; ++i){
            if(card[i])
                for (int j = i*2; j < MAX_CARD_SIZE; j+=i) {
                    if(card[j]){
                        score[i]++;
                        score[j]--;
                    }
                }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(score[player[i]] + " ");
        }
        System.out.println();
        br.close();
    }
}
