import java.util.*;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        int max = 0;
        for (int x : nodes) max = Math.max(max, x);
        List<Integer>[] g = new ArrayList[max + 1];
        boolean[] present = new boolean[max + 1];
        for (int x : nodes) {
            present[x] = true;
            g[x] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }

        boolean[] vis = new boolean[max + 1];
        int forwardAns = 0;
        int reverseAns = 0;

        for (int start : nodes) {
            if (vis[start]) continue;

            List<Integer> comp = new ArrayList<>();
            Deque<Integer> dq = new ArrayDeque<>();
            dq.add(start);
            vis[start] = true;
            while (!dq.isEmpty()) {
                int u = dq.poll();
                comp.add(u);
                for (int v : g[u]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        dq.add(v);
                    }
                }
            }

            int badNrForward = 0;      
            int countRootOkForward = 0; 
            int badNrReverse = 0;       
            int countRootOkReverse = 0;

            for (int u : comp) {
                int deg = g[u].size();
                int a = (u & 1);           
                int childNrParityNonRoot = (deg - 1) & 1; 
                int childNrParityRoot    =  deg       & 1;

                if (a != childNrParityNonRoot) badNrForward++;
                if (a == childNrParityRoot)    countRootOkForward++;

                if (a == childNrParityNonRoot) badNrReverse++;
                if (a != childNrParityRoot)    countRootOkReverse++;
            }

            if (badNrForward == 0) {
                forwardAns += countRootOkForward;
            } else if (badNrForward == 1) {
                forwardAns += 1;
            }

            if (badNrReverse == 0) {
                reverseAns += countRootOkReverse;
            } else if (badNrReverse == 1) {
                reverseAns += 1;
            }
        }

        return new int[]{forwardAns, reverseAns};
    }
}