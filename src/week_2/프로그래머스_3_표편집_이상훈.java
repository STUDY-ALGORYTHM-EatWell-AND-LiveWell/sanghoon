package week_2;

import java.util.*;

public class 프로그래머스_3_표편집_이상훈 {
    class Node{
        boolean removed;
        Node prev;
        Node next;
    }

    public String solution(int n, int k, String[] cmds) {

        Node[] nodeArr = new Node[n];
        for(int i=0; i<n; i++){
            nodeArr[i] = new Node();
        }
        for(int i=1; i<n; i++){
            nodeArr[i-1].next = nodeArr[i];
            nodeArr[i].prev = nodeArr[i-1];
        }

        Node curr = nodeArr[k];
        Stack<Node> stack = new Stack<>();

        for(String str : cmds){
            if(str.charAt(0)=='U'){
                int x = Integer.parseInt(str.substring(2));
                for(int i=0; i<x; i++)
                    curr = curr.prev;
            }
            else if(str.charAt(0)=='D'){
                int x = Integer.parseInt(str.substring(2));
                for(int i=0; i<x; i++)
                    curr = curr.next;

            }
            else if(str.charAt(0)=='C'){
                stack.push(curr);
                curr.removed = true;
                Node up = curr.prev;
                Node down = curr.next;
                if(up !=null)
                    up.next = down;
                if(down !=null){
                    down.prev = up;
                    curr = down;
                }
                else
                    curr = up;
            }
            else{
                Node node = stack.pop();
                node.removed = false;
                Node up = node.prev;
                Node down = node.next;
                if(up!=null)
                    up.next = node;
                if(down!=null)
                    down.prev = node;
            }
        }

        StringBuilder answer = new StringBuilder();
        for(int i=0; i<n; i++){
            if(nodeArr[i].removed)
                answer.append('X');
            else
                answer.append('O');
        }
        return answer.toString();
    }


    // 처음 접근한 풀이(오답)
    public String wrongSolution(int n, int k, String[] cmds) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(i);

        Stack<Integer> stack = new Stack<>();
        int idx = k;
        for(int i=0; i<cmds.length; i++) {
            String cmd = cmds[i];
            if (cmd.charAt(0) == 'U') {
                idx -= Integer.valueOf(cmd.substring(2, cmd.length()));
            }
            else if (cmd.charAt(0) == 'D') {
                idx += Integer.valueOf(cmd.substring(2, cmd.length()));
            }
            else if (cmd.charAt(0) == 'C') {
                stack.push(list.get(idx));
                list.remove(idx);
                if (idx == list.size())
                    idx--;
            }
            else {
                // stack에서 pop()한 원소의 자리를 찾기 위해 list에서 이분탐색으로 접근 ...

            }
        }


        //...
        return "";
    }
}