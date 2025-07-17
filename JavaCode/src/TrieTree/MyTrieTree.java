package src.TrieTree;

public class MyTrieTree {
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

    Node1 root;

    public MyTrieTree(){
        root=new Node1();
    }

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

    public int countWordsStartingWith(String pre){
        if(pre==null){
            return 0;
        }
        char[] chars=pre.toCharArray();
        Node1 node=root;
        for(int i=0;i<pre.length();i++){
            if(node.nexts[chars[i]-'a']==null){
                return 0;
            }
            node=node.nexts[chars[i]-'a'];
        }
        return node.pass;
    }

    public int countWordsEqualTo(String pre){
        if(pre==null){
            return 0;
        }
        char[] chars=pre.toCharArray();
        Node1 node=root;
        for(int i=0;i<chars.length;i++){
            if(node.nexts[chars[i]-'a']==null){
                return 0;
            }
            node=node.nexts[chars[i]-'a'];
        }
        return node.end;
    }

    public void delete(String word){
        if(countWordsEqualTo(word)>0){
            char[] chars=word.toCharArray();
            Node1 node=root;
            node.pass--;
            for (int i = 0; i < chars.length; i++) {
                int path = chars[i]-'a';
                if(--node.nexts[path].pass==0){
                    node.nexts[path]=null;
                    return;
                }
                node=node.nexts[path];
            }
            node.end--;
        }
    }
    public static void main(String[] args) {
        MyTrieTree trie = new MyTrieTree();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("app");

        System.out.println(trie.countWordsEqualTo("app")); // 2
        System.out.println(trie.countWordsStartingWith("ap")); // 3

        trie.delete("app");
        System.out.println(trie.countWordsEqualTo("app")); // 1
        System.out.println(trie.countWordsStartingWith("ap")); // 2
    }
}


