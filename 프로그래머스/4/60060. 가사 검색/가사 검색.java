import java.util.*;

class Solution {

    static class Node {
        Node[] child = new Node[26];
        int cnt; 
    }

    static class Trie {
        Node root = new Node();

        void insert(String s) {
            Node cur = root;
            cur.cnt++;                
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if (cur.child[idx] == null) cur.child[idx] = new Node();
                cur = cur.child[idx];
                cur.cnt++;
            }
        }

        int count(String pattern) {
            Node cur = root;
            for (int i = 0; i < pattern.length(); i++) {
                char ch = pattern.charAt(i);
                if (ch == '?') {          
                    return cur.cnt;
                }
                int idx = ch - 'a';
                if (cur.child[idx] == null) return 0;
                cur = cur.child[idx];
            }

            return cur.cnt;
        }
    }

    public int[] solution(String[] words, String[] queries) {
        final int MAX_LEN = 10000;
        Trie[] forward = new Trie[MAX_LEN + 1]; 
        Trie[] reverse = new Trie[MAX_LEN + 1];

        for (String w : words) {
            int L = w.length();
            if (forward[L] == null) {
                forward[L] = new Trie();
                reverse[L] = new Trie();
            }
            forward[L].insert(w);
            reverse[L].insert(new StringBuilder(w).reverse().toString());
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int L = q.length();
            if (L > MAX_LEN || forward[L] == null) {
                answer[i] = 0;
                continue;
            }

            if (q.charAt(0) == '?') {
                String rq = new StringBuilder(q).reverse().toString();
                answer[i] = reverse[L].count(rq);
            } else {
                answer[i] = forward[L].count(q);
            }
        }

        return answer;
    }
}