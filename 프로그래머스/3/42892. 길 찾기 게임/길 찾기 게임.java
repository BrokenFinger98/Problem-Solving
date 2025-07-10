import java.util.*;
import java.lang.*;

class Solution {
    private class Node implements Comparable<Node> {
        int y, x, element;
        Node left, right;
        
        public Node(int y, int x, int element){
            this.y = y;
            this.x = x;
            this.element = element;
        }
        
        @Override
        public int compareTo(Node node){
            if(this.y == node.y) return this.x - node.x;
            return node.y - this.y;
        }
    }
    
    private static List<Integer> preorderList = new ArrayList<>();
    private static List<Integer> postorderList = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> list = new ArrayList<>();
        
        for(int i = 0; i < nodeinfo.length; ++i){
            list.add(new Node(nodeinfo[i][1], nodeinfo[i][0], i + 1));
        }
        
        Collections.sort(list);
        
        Node root = list.get(0);
        for(int i = 1; i < nodeinfo.length; ++i){
            insert(root, list.get(i));
        }
        
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }

        return answer;
    }
    
    private void insert(Node parent, Node child){
        if(child.x < parent.x){
            if(parent.left == null) parent.left = child;
            else insert(parent.left, child);
        }else {
            if(parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    private void preorder(Node node){
        if(node == null) return;
        preorderList.add(node.element);
        preorder(node.left);
        preorder(node.right);
    }
    
    private void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.element);
    }
}