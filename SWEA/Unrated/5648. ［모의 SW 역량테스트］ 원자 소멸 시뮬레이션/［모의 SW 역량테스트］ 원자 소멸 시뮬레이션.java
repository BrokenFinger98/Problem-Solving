import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Atom {
        int x, y, dir, energy;

        public Atom(int x, int y, int dir, int energy) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }
    }

    static class Collision implements Comparable<Collision>{
        int i1, i2, dist;

        public Collision(int i1, int i2, int dist) {
            this.i1 = i1;
            this.i2 = i2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Collision o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<Atom> atoms = new ArrayList<>();
            PriorityQueue<Collision> pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());
                atoms.add(new Atom(x, y, dir, energy));
            }

            for (int i = 0; i < N; i++) {
                Atom atom1 = atoms.get(i);
                for (int j = i + 1; j < N; j++) {
                    Atom atom2 = atoms.get(j);
                    if(atom1.x == atom2.x && atom1.y > atom2.y && atom1.dir == 1 && atom2.dir == 0) {
                        pq.offer(new Collision(i, j, atom1.y - atom2.y));
                    } else if(atom1.x == atom2.x && atom1.y < atom2.y && atom1.dir == 0 && atom2.dir == 1) {
                        pq.offer(new Collision(i, j, atom2.y - atom1.y));
                    } else if(atom1.y == atom2.y && atom1.x > atom2.x && atom1.dir == 2 && atom2.dir == 3) {
                        pq.offer(new Collision(i, j, atom1.x - atom2.x));
                    } else if(atom1.y == atom2.y && atom1.x < atom2.x && atom1.dir == 3 && atom2.dir == 2) {
                        pq.offer(new Collision(i, j, atom2.x - atom1.x));
                    } else if(Math.abs(atom1.x - atom2.x) == Math.abs(atom1.y - atom2.y)) {
                        if(atom1.x > atom2.x && atom1.y > atom2.y) {
                            if((atom1.dir == 1 && atom2.dir == 3) || (atom1.dir == 2 && atom2.dir == 0)) {
                                pq.offer(new Collision(i, j, 2*(atom1.x - atom2.x)));
                            }
                        } else if(atom1.x < atom2.x && atom1.y < atom2.y) {
                            if((atom1.dir == 3 && atom2.dir == 1) || (atom1.dir == 0 && atom2.dir == 2)) {
                                pq.offer(new Collision(i, j, 2*(atom2.x - atom1.x)));
                            }
                        } else if(atom1.x > atom2.x && atom1.y < atom2.y) {
                            if((atom1.dir == 0 && atom2.dir == 3) || (atom1.dir == 2 && atom2.dir == 1)) {
                                pq.offer(new Collision(i, j, 2*(atom1.x - atom2.x)));
                            }
                        } else if (atom1.x < atom2.x && atom1.y > atom2.y) {
                            if((atom1.dir == 3 && atom2.dir == 0) || (atom1.dir == 1 && atom2.dir == 2)) {
                                pq.offer(new Collision(i, j, 2*(atom2.x - atom1.x)));
                            }
                        }
                    }
                }
            }

            int totalEnergy = 0;
            Set<Integer> set = new HashSet<>();
            Set<Integer> tmp = new HashSet<>();
            while (!pq.isEmpty()) {
                Collision collision = pq.poll();
                if(set.contains(collision.i1) || set.contains(collision.i2)) continue;
                tmp.add(collision.i1);
                tmp.add(collision.i2);
                while (!pq.isEmpty() && pq.peek().dist == collision.dist){
                    collision = pq.poll();
                    if(set.contains(collision.i1) || set.contains(collision.i2)) continue;
                    tmp.add(collision.i1);
                    tmp.add(collision.i2);
                }
                set.addAll(tmp);
                tmp.clear();
            }
            for (Integer i : set) {
                totalEnergy += atoms.get(i).energy;
            }
            sb.append("#").append(t).append(" ").append(totalEnergy).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
