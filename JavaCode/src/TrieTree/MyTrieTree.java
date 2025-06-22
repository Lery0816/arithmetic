package src.TrieTree;

public class MyTrieTree {
    private Node1 root=new Node1();
    public void insert(String word){
        if(word==null||word.length()==0){
            return;
        }
        char[] chars=word.toCharArray();
        Node1 node=root;
        for (int i = 0; i < chars.length; i++) {
            int path = chars[i]-'a';
            if(node.nexts[path]==null){
                node.nexts[path]=new Node1();
            }
            node=node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

}

class Node1 {
    public int pass;
    public int end;
    public Node1[] nexts;
    public Node1 (){
        pass = 0;
        end = 0;
        nexts = new Node1[26];
    }
}
