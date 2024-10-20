import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    static class Node{
        TreeMap<String, Node> children = new TreeMap<>();
    }
    static Node root = new Node();
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; ++i){
            String[] texts = br.readLine().split("\\\\");
            insertText(texts);
        }
        printTrie(root, 0);
        System.out.print(sb);
        br.close();
    }

    static void insertText(String[] texts){
        Node node = root;
        for (String text : texts) {
            node.children.putIfAbsent(text, new Node());
            node = node.children.get(text);
        }
    }
    
    static void printTrie(Node node, int depth){
        for (String key : node.children.keySet()) {
            for (int i = 0; i < depth; i++) {
                sb.append(" ");
            }
            sb.append(key).append("\n");
            printTrie(node.children.get(key), depth + 1);
        }
    }
}