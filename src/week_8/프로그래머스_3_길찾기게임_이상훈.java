package week_8;
import java.util.*;

public class 프로그래머스_3_길찾기게임_이상훈 {
    class Solution {
        class Node implements Comparable<Node>{
            int num;
            int x;
            int y;
            Node left;
            Node right;

            public Node(int num, int x, int y){
                this.num = num;
                this.x = x;
                this.y = y;
            }

            // y 기준 내림차순, y가 같다면 x 기준 오름차순
            @Override
            public int compareTo(Node n){
                if(this.y==n.y)
                    return n.x-this.x;
                else
                    return n.y-this.y;
            }
        }

        // 이진 트리 구성
        public void makeTree(Node parent, Node child){
            if(parent.x<child.x){
                if(parent.right == null)
                    parent.right = child;
                else
                    makeTree(parent.right, child);
            }
            else{
                if(parent.left == null)
                    parent.left = child;
                else
                    makeTree(parent.left, child);
            }
        }

        // 전위 순회
        public void preorder(Node node, List<Integer> list){
            list.add(node.num);
            if(node.left!=null)
                preorder(node.left, list);
            if(node.right!=null)
                preorder(node.right, list);
        }

        // 후위 순회
        public void postorder(Node node, List<Integer> list){
            if(node.left!=null)
                postorder(node.left, list);
            if(node.right!=null)
                postorder(node.right, list);
            list.add(node.num);
        }

        public int[][] solution(int[][] nodeinfo) {

            // 노드 객체 저장
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i=0; i<nodeinfo.length; i++){
                int[] node = nodeinfo[i];
                pq.offer(new Node(i+1, node[0], node[1]));
            }

            // 이진트리 구성
            Node root = pq.poll();
            while(!pq.isEmpty()){
                Node now = pq.poll();
                makeTree(root, now);
            }

            // 전위, 후위 순회 수행
            List<Integer> preOrderList = new ArrayList<>();
            List<Integer> postOrderList = new ArrayList<>();
            preorder(root, preOrderList);
            postorder(root, postOrderList);

            // 결과 배열 반환
            int[][] answers = new int[2][nodeinfo.length];
            for(int i=0; i<nodeinfo.length; i++){
                answers[0][i] = preOrderList.get(i);
                answers[1][i] = postOrderList.get(i);
            }
            return answers;
        }
    }
}
