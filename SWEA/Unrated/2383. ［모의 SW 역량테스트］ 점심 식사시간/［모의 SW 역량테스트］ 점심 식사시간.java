import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Person{
        int y;
        int x;

        public Person(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static class Inter{
        int y;
        int x;
        int weight;

        public Inter(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }
    }
    static int T, N, answer;
    static int[][] map;
    static List<Inter> listInter;
    static List<Person> listPerson;
    static List<Person>[] list;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            answer = Integer.MAX_VALUE;
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            listInter = new ArrayList<>();
            listPerson = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] >= 2) listInter.add(new Inter(i, j, map[i][j]));
                    else if(map[i][j] == 1) listPerson.add(new Person(i, j));
                }
            }
            isSelected = new boolean[listPerson.size()];
            subset(0);
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb.toString());
        }
    }
    static void subset(int depth){
        if(depth == listPerson.size()){
            list = new List[2];
            list[0] = new ArrayList<>();
            list[1] = new ArrayList<>();
            for (int i = 0; i < isSelected.length; i++) {
                if(isSelected[i]) list[0].add(listPerson.get(i));
                else list[1].add(listPerson.get(i));
            }
            answer = Math.min(answer, Math.max(move(0), move(1)));
            return;
        }

        isSelected[depth] = true;
        subset(depth + 1);

        isSelected[depth] = false;
        subset(depth + 1);
    }
    static int move(int interNumber){
        if(list[interNumber].isEmpty()) return 0;

        int[] dist = new int[list[interNumber].size()];
        for (int i = 0; i < list[interNumber].size(); i++) {
            dist[i] = Math.abs(listInter.get(interNumber).y - list[interNumber].get(i).y) + Math.abs(listInter.get(interNumber).x - list[interNumber].get(i).x);
        }
        Arrays.sort(dist);
        int cnt = dist[dist.length-1] + listInter.get(interNumber).weight;
        if(dist.length > 3){
            if(dist[dist.length-1] < listInter.get(interNumber).weight + dist[dist.length-4]){
                cnt += listInter.get(interNumber).weight + dist[dist.length-4] - dist[dist.length-1];
            }
        }

        return cnt + 1;
    }
}
